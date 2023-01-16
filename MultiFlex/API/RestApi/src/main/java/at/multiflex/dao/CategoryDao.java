package at.multiflex.dao;

import at.multiflex.dto.CategoryDto;
import at.multiflex.dto.wares.ArticleDto;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.mapper.ObjectMapper;
import at.multiflex.model.Category;
import at.multiflex.repository.CRUDOperations;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * This class includes all json requests for the Category class
 */
@Dependent
@Path("/Category")
public class CategoryDao {
    /**
     * A Constructor that tells the superclass which entity class to use
     */
    public CategoryDao() {
        type = Category.class;
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

    /**
     * repository for the Category class
     */
    @Inject
    protected at.multiflex.repository.CategoryRepository repository;
    /**
     * This gets all entities with this type from the Database and returns a list with them
     * @return a list with all Dtos
     * @throws DaoException throws a DaoException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Object> getAll() {
        List<Category> entities = repository.loadAll();

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
    public Object getByName(String name) {
        if(name == null) {
            throw new IllegalArgumentException("input is null");
        }
        Category entities = repository.findByName(name);

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
        Category entity = repository.findById(id);

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
    public Response add(CategoryDto input) {
        if(input == null) {
            throw new IllegalArgumentException("input is null");
        }
        var entity = (Category) MappingHelper.entityDtoTransformation(input);
        entity.setType(input.getType());

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
    public Response delete(@PathParam("id") Integer id) {
        if(id == null) {
            throw new IllegalArgumentException("input is null");
        }
        Object entity  = repository.findById(id);

        crudOperations.delete(entity);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    /**
     * Returns all Products by categories
     * @return The resulting List
     */
    @Path("/Product")
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Object> getAllProducts() {
        var entities = repository.loadAllProducts();

        return MappingHelper.entityDtoTransformation(entities);
    }
    /**
     * Returns all Materials by categories
     * @return The resulting List
     */
    @Path("/Material")
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Object> getAllMaterials() {
        var entities = repository.loadAllMaterials();

        return MappingHelper.entityDtoTransformation(entities);
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/updateByName")
    public Response updateByName(CategoryDto dto) {
        if(dto == null) {
            throw new IllegalArgumentException("input is null");
        }
        var entity = repository.findByName(dto.getName());

        var entity2 = ObjectMapper.MAPPER.fromDto(dto);

        if (entity2.getAcronym() != null) {
            entity.setAcronym(entity2.getAcronym());
        }
        if (entity2.getType() != null) {
            entity.setType(entity2.getType());
        }

        crudOperations.update(entity);
        return Response.status(Response.Status.OK).build();
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/update")
    public Response update(CategoryDto dto) {
        if(dto == null) {
            throw new IllegalArgumentException("input is null");
        }
        var entity = repository.findById(dto.getId());

        var entity2 = ObjectMapper.MAPPER.fromDto(dto);

        if (entity2.getName() != null) {
            entity.setName(entity2.getName());
        }
        if (entity2.getAcronym() != null) {
            entity.setAcronym(entity2.getAcronym());
        }
        if (entity2.getType() != null) {
            entity.setType(entity2.getType());
        }

        crudOperations.update(entity);
        return Response.status(Response.Status.OK).build();
    }
}
