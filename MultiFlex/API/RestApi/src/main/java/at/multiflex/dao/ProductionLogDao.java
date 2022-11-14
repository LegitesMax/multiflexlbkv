package at.multiflex.dao;

import at.multiflex.Logic.CRUDLogic;
import at.multiflex.Logic.ProductionLogic;
import at.multiflex.dto.ProductionLogDto;
import at.multiflex.dto.wares.ProductDto;
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
    public List<Object> getAll() throws DaoException {
        List<ProductionLog> entities;
        if (ProductionLog.class.equals(type)) {
            entities = repository.loadAll();
        } else{
            throw new DaoException("Entity does not exist");
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
        ProductionLog entity;
        if (ProductionLog.class.equals(type)) {
            entity = repository.findById(id);
        } else{
            throw new DaoException("Entity does not exist");
        }
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
    public Response delete(@PathParam("id") Integer id) throws DaoException {
        Object entity;
        if (ProductionLog.class.equals(type)) {
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
    /**
     * transforms a given dto to an entity and increases the amount of Products
     * @param input A dto to insert into the database
     * @return The JSON Response code
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Consumes
    @Path("/produce")
    public Response produce(ProductDto input) {
        var entity = (Product) MappingHelper.entityDtoTransformation(input);

        logic.produce(entity);

        return Response.status(Response.Status.CREATED).build();
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
    public Response add(ProductionLogDto input) {
        var entity = (ProductionLog) MappingHelper.entityDtoTransformation(input);

        crudOperations.add(entity);
        logic.consume(entity.getProduct());

        return Response.status(Response.Status.CREATED).build();
    }
}
