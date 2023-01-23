package at.multiflex.dao;

import at.multiflex.Logic.ProductionLogic;
import at.multiflex.dto.ProductionLogDto;
import at.multiflex.dto.logic.Production;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.model.ProductionLog;
import at.multiflex.model.Wares.Product;
import at.multiflex.repository.CRUDOperations;
import at.multiflex.repository.ProductionLogRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * This class includes all json requests for the ProductionLog class
 */
@Dependent
@Path("/ProductionLog")
public class ProductionLogDao {
    /**
     * A Constructor that tells the superclass which entity class to use
     */
    public ProductionLogDao() {
        type = ProductionLog.class;
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
    ProductionLogic logic;

    /**
     * repository for the ProductionLog class
     */
    @Inject
    protected ProductionLogRepository repository;
    /**
     * This gets all entities with this type from the Database and returns a list with them
     * @return a list with all Dtos
     * @throws DaoException throws a DaoException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Object> getAll() {
        List<ProductionLog> entities = repository.loadAll();

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
    public Object getById(Integer id)  {
        if(id == null) {
            throw new IllegalArgumentException("input is null");
        }
        ProductionLog entity = repository.findById(id);

        return MappingHelper.entityDtoTransformation(entity);
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
    public Response delete(@PathParam("id") Integer id)  {
        if(id == null) {
            throw new IllegalArgumentException("input is null");
        }
        Object entity = repository.findById(id);

        crudOperations.delete(entity);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    /**
     * transforms a given dto to an entity and increases the amount of Products
     * @param input A dto to insert into the database
     * @return The JSON Response code
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Consumes
    @Path("/produce")
    public Response produce(Production input) {
        if(input == null) {
            throw new IllegalArgumentException("input is null");
        }
        var entity = (Product) MappingHelper.entityDtoTransformation(input.getProduct());

        logic.produce(entity, input.getAmount().intValue());

        return Response.status(Response.Status.NO_CONTENT).build();
    }
    /**
     * transforms a given dto to an entity and adds it into the database
     * @param input A dto to insert into the database
     * @return The JSON Response code
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Consumes
    @Path("/consume")
    public Response consume(Production input) {
        if(input == null) {
            throw new IllegalArgumentException("input is null");
        }
        var entity = (Product) MappingHelper.entityDtoTransformation(input.getProduct());

        logic.consume(entity, input.getAmount().intValue());

        return Response.status(Response.Status.CREATED).build();
    }

    /**
     * transforms a given dto to an entity and increases the amount of Products
     * @param input A dto to insert into the database
     * @return The JSON Response code
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Consumes
    @Path("/fixStock")
    public Response fixStock(Production input) {
        if(input == null) {
            throw new IllegalArgumentException("input is null");
        }
        var entity = (Product) MappingHelper.entityDtoTransformation(input.getProduct());

        logic.fixStock(entity, input.getAmount());

        return Response.status(Response.Status.CREATED).build();
    }
}
