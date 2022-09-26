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

/**
 * This class includes all json requests for the Size class
 */
@Dependent
@Path("/Size")
public class SizeDao {@Inject
    SizeRepository repository;

    //<editor-fold desc="Get">
    /**
     * This gets all entities with this type from the Database and returns a list with them
     * @return a list with all SizeDtos
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<SizeDto> getAll() {
        var entities = repository.loadAll();

        return toDto(entities);
    }
    /**
     * gets an entity from this class by its id
     * @param id the id of the Size to return
     * @return The Size with the id of the input param
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/{id}")
    public SizeDto getById(Integer id) {
        var entity = repository.findById(id);
        return ObjectMapper.MAPPER.toDto(entity);
    }
    //</editor-fold>
    //<editor-fold desc="Post">
    /**
     * transforms a given dto to an entity and adds it into the database
     * @param dto A dto to insert into the database
     * @return The JSON Response code
     */
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
    /**
     * Deletes a Size entity by that entities id
     * @param id The id of an entity to delete
     * @return The JSON Response code
     */
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
    /**
     * Transforms a dto into an Size and updates it
     * @param dto The dto of the entity
     * @return The JSON Response code
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/update")
    public Response update(SizeDto dto) {
        var entity = ObjectMapper.MAPPER.fromDto(dto);
        repository.update(entity);
        return Response.status(Response.Status.OK).build();
    }
    //</editor-fold>
    /**
     * Method to transform a list of Size entities to a dto
     * @param entities list of all Size entities to transform
     * @return the dtos of all given entities
     */
    public List<SizeDto> toDto(List<Size> entities) {
        var dtos = new ArrayList<SizeDto>();
        entities.forEach(x -> dtos.add(ObjectMapper.MAPPER.toDto(x)));
        return dtos;
    }
    /**
     * Method to transform a list of Size dtos to entities
     * @param dtos list of all Size dtos to transform
     * @return the entities of all given entities
     */
    public List<Size> fromDto(List<SizeDto> dtos) {
        var result = new ArrayList<Size>();
        dtos.forEach(x -> result.add(ObjectMapper.MAPPER.fromDto(x)));
        return result;
    }
}
