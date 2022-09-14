package at.multiflex.dao;

import at.multiflex.dto.CategoryDto;
import at.multiflex.dto.ColorDto;
import at.multiflex.mapper.ObjectMapper;
import at.multiflex.model.Category;
import at.multiflex.model.Color;
import at.multiflex.repository.CategoryRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Dependent
@Path("/Category")
public class CategoryDao {
    @Inject
    CategoryRepository repository;

    //<editor-fold desc="Get">
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<CategoryDto> getAll() {
        var entities = repository.loadAll();

        return toDto(entities);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/{name}")
    public CategoryDto getByName(String name) {
        var entities = repository.findByName(name);
        return ObjectMapper.MAPPER.toDto(entities);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/{id}")
    public CategoryDto getById(Integer id) {
        var entity = repository.findById(id);
        return ObjectMapper.MAPPER.toDto(entity);
    }
    //</editor-fold>
    //<editor-fold desc="Post">
    @POST
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/add")
    public Response add(CategoryDto dto) {
        var entity = ObjectMapper.MAPPER.fromDto(dto);
        repository.add(entity);
        return Response.status(Response.Status.CREATED).build();
    }
    //</editor-fold>
    //<editor-fold desc="Delete">
    @DELETE
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Integer id) {
        var entity = repository.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        repository.delete(entity);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    //</editor-fold>
    //<editor-fold desc="Put">
    @PUT
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/update")
    public Response update(CategoryDto dto) {
        var entity = ObjectMapper.MAPPER.fromDto(dto);
        repository.update(entity);
        return Response.status(Response.Status.OK).build();
    }
    //</editor-fold>
    public List<CategoryDto> toDto(List<Category> entities) {
        var dtos = new ArrayList<CategoryDto>();
        entities.forEach(x -> dtos.add(ObjectMapper.MAPPER.toDto(x)));
        return dtos;
    }
}
