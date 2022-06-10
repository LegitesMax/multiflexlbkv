package at.multiflex.dao;

import at.multiflex.dto.CategoryDto;
import at.multiflex.dto.ColorDto;
import at.multiflex.mapper.CategoryMapper;
import at.multiflex.mapper.ColorMapper;
import at.multiflex.repository.CategoryRepository;
import at.multiflex.repository.ColorRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Dependent
@Path("/Category")
public class CategoryDao {
    @Inject
    CategoryRepository repository;

    @Inject
    CategoryMapper mapper;

    //<editor-fold desc="Get">
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<CategoryDto> getAll() {
        var entities = repository.loadAll();
        return mapper.toDto(entities);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/get/{name}")
    public List<CategoryDto> getByName(String name) {
        var entities = repository.findByName(name);
        return mapper.toDto(entities);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/get/{id}")
    public CategoryDto getById(Integer id) {
        var entity = repository.findById(id);
        return mapper.toDto(entity);
    }
    //</editor-fold>
    //<editor-fold desc="Post">
    @POST
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/add")
    public Response add(CategoryDto dto) {
        var entity = mapper.fromDto(dto);
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
        var entity = mapper.fromDto(dto);
        repository.update(entity);
        return Response.status(Response.Status.OK).build();
    }
    //</editor-fold>
}
