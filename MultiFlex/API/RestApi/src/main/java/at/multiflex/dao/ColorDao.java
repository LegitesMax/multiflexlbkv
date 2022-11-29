package at.multiflex.dao;

import at.multiflex.Logic.CRUDLogic;
import at.multiflex.dto.CategoryDto;
import at.multiflex.dto.ColorDto;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.mapper.ObjectMapper;
import at.multiflex.model.Color;
import at.multiflex.repository.CRUDOperations;
import at.multiflex.repository.ColorRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * This class includes all json requests for the Color class
 */
@Dependent
@Path("/Color")
public class ColorDao {
    /**
     * A Constructor that tells the superclass which entity class to use
     */
    public ColorDao() {
        type = Color.class;
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
     * repository for the Color class
     */
    @Inject
    protected ColorRepository repository;
    /**
     * This gets all entities with this type from the Database and returns a list with them
     * @return a list with all Dtos
     * @throws DaoException throws a DaoException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Object> getAll() throws DaoException {
        List<Color> entities;
        if (Color.class.equals(type)) {
            entities = repository.loadAll();
        } else{
            throw new DaoException("Entity does not exist");
        }

        return MappingHelper.entityDtoTransformation(entities);
    }
    /**
     * This gets specific entities from this type from the Database and returns a list with them
     * @param name name which should be searched
     * @return All entities with this name
     * @throws DaoException throws a DaoException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/name/{name}")
    public Object getByName(String name) throws DaoException {
        Color entities;
        if (Color.class.equals(type)) {
            entities = repository.findByName(name);
        } else{
            throw new DaoException("Entity does not have a name, or no available DB request");
        }
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
    public Object getById(Integer id) throws DaoException {
        Color entity;
        if (Color.class.equals(type)) {
            entity = repository.findById(id);
        } else{
            throw new DaoException("Entity does not exist");
        }
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
    public Response add(ColorDto input) {
        var entity = (Color) MappingHelper.entityDtoTransformation(input);

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
        Object entity;
        if (Color.class.equals(type)) {
            entity = repository.findById(id);
        } else{
            throw new DaoException("Entity does not exist");
        }
        if(entity == null) {
            throw new NotFoundException();
        }

        crudOperations.delete(entity);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/update")
    public Response update(ColorDto dto) {
        var entity = repository.findByName(dto.getName());

        var entity2 = ObjectMapper.MAPPER.fromDto(dto);

        if (entity2.getName() != null) {
            entity.setName(entity2.getName());
        }
        if (entity2.getColorCode() != null) {
            entity.setColorCode(entity2.getColorCode());
        }

        crudOperations.update(entity);
        return Response.status(Response.Status.OK).build();
    }
}
