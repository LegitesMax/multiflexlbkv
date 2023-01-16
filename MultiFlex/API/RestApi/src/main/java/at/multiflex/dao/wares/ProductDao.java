package at.multiflex.dao.wares;

import at.multiflex.Logic.CRUDLogic;
import at.multiflex.dao.DaoException;
import at.multiflex.dto.wares.ProductDto;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.model.Wares.Product;
import at.multiflex.repository.CRUDOperations;
import at.multiflex.repository.wares.ProductRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * This class includes all json requests for the Article class
 */
@Dependent
@Path("/Product")
public class ProductDao {
    /**
     * A Constructor that tells the superclass which entity class to use
     */
    public ProductDao() {
        type = Product.class;
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
     * repository for the Product class
     */
    @Inject
    protected ProductRepository repository;
    /**
     * This gets all entities with this type from the Database and returns a list with them
     * @return a list with all Dtos
     * @throws DaoException throws a DaoException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Object> getAll() throws DaoException {
        List<Product> entities = repository.loadAll();

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
    public List<Object> getByName(String name) throws DaoException {
        if(name == null) {
            throw new IllegalArgumentException("input is null");
        }
        List<Product> entities = repository.findByName(name);

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
        if(id == null) {
            throw new IllegalArgumentException("input is null");
        }
        Product entity = repository.findById(id);

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
    public Response add(ProductDto input) {
        if(input == null) {
            throw new IllegalArgumentException("input is null");
        }
        var entity = (Product) MappingHelper.entityDtoTransformation(input);

        entity = crudLogic.setEmptyFields(entity);

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
}
