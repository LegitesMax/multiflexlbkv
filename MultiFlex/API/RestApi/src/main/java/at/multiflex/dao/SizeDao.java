package at.multiflex.dao;

import at.multiflex.dto.SizeDto;
import at.multiflex.mapper.ObjectMapper;
import at.multiflex.model.Size;
import at.multiflex.repository.SizeRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Dependent
@Path("/Size")
public class SizeDao {@Inject
    SizeRepository repository;

    //<editor-fold desc="Get">
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<SizeDto> getAll() {
        var entities = repository.loadAll();

        return toDto(entities);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/{id}")
    public SizeDto getById(Integer id) {
        var entity = repository.findById(id);
        return ObjectMapper.MAPPER.toDto(entity);
    }
    //</editor-fold>
    //<editor-fold desc="Post">
    @POST
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/add")
    public Response add(SizeDto dto) {
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
    public Response update(SizeDto dto) {
        var entity = ObjectMapper.MAPPER.fromDto(dto);
        repository.update(entity);
        return Response.status(Response.Status.OK).build();
    }
    //</editor-fold>

    public List<SizeDto> toDto(List<Size> entities) {
        var dtos = new ArrayList<SizeDto>();
        entities.forEach(x -> dtos.add(ObjectMapper.MAPPER.toDto(x)));
        return dtos;
    }

    public List<Size> fromDto(List<SizeDto> dtos) {
        var result = new ArrayList<Size>();
        dtos.forEach(x -> result.add(ObjectMapper.MAPPER.fromDto(x)));
        return result;
    }
}
