package at.multiflex.dao;

import at.multiflex.Logic.CRUDLogic;
import at.multiflex.dto.ColorDto;
import at.multiflex.dto.SizeDto;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.mapper.ObjectMapper;
import at.multiflex.model.Size;
import at.multiflex.repository.CRUDOperations;
import at.multiflex.repository.SizeRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * This class includes all json requests for the Size class
 */
@Dependent
@Path("/Size")
public class SizeDao {
    /**
     * A Constructor that tells the superclass which entity class to use
     */
    public SizeDao() {
        type = Size.class;
    }

    /**
     * type of the class
     */
    protected Class<?> type;
    /**
     * all create update delete operations
     */
    @Inject
    protected CRUDOperations crudOperations;
    @Inject
    CRUDLogic crudLogic;

    /**
     * repository for the Size class
     */
    @Inject
    protected SizeRepository repository;
    /**
     * This gets all entities with this type from the Database and returns a list with them
     * @return a list with all Dtos
     * @throws DaoException throws a DaoException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Object> getAll() {
        List<Size> entities = repository.loadAll();

        return MappingHelper.entityDtoTransformation(entities);
    }
    /**
     * gets an entity from this class by its id
     * @param id the id of the class to return
     * @return The class with the id of the input param
     * @throws DaoException throws a DaoException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/{id}")
    public Object getById(Integer id) {
        if(id == null) {
            throw new IllegalArgumentException("input is null");
        }
        Size entity = repository.findById(id);
        return MappingHelper.entityDtoTransformation(entity);
    }
    /**
     * transforms a given dto to an entity and adds it into the database
     * @param input A dto to insert into the database
     * @return The JSON Response code
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Consumes
    @Path("/add")
    public Response add(SizeDto input) {
        if(input == null) {
            throw new IllegalArgumentException("input is null");
        }
        var entity = (Size) MappingHelper.entityDtoTransformation(input);

        crudOperations.add(entity);

        return Response.status(Response.Status.CREATED).build();
    }
    /**
     * Deletes a entity by that entities id
     * @param id The id of an entity to delete
     * @return The JSON Response code
     * @throws DaoException throws a DaoException
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Integer id) throws DaoException {
        if(id == null) {
            throw new IllegalArgumentException("input is null");
        }
        Object entity = repository.findById(id);

        crudOperations.delete(entity);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/updateBySize")
    public Response updateBySize(SizeDto dto) {
        if(dto == null) {
            throw new IllegalArgumentException("input is null");
        }
        var entity = repository.findBySize(dto.getSize());

        var entity2 = ObjectMapper.MAPPER.fromDto(dto);

        if (entity2.getDescription() != null) {
            entity.setDescription(entity2.getDescription());
        }

        crudOperations.update(entity);
        return Response.status(Response.Status.OK).build();
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/update")
    public Response update(SizeDto dto) {
        if(dto == null) {
            throw new IllegalArgumentException("input is null");
        }
        var entity = repository.findById(dto.getId());

        var entity2 = ObjectMapper.MAPPER.fromDto(dto);

        if (entity2.getSize() != null) {
            entity.setSize(entity2.getSize());
        }
        if (entity2.getDescription() != null) {
            entity.setDescription(entity2.getDescription());
        }

        crudOperations.update(entity);
        return Response.status(Response.Status.OK).build();
    }
}
