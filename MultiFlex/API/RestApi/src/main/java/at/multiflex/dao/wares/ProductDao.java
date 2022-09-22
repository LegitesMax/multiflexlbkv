package at.multiflex.dao.wares;

import at.multiflex.dto.wares.ProductDto;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.model.Wares.Product;
import at.multiflex.repository.wares.ProductRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * This class includes all json requests for the Article class
 */
@Dependent
@Path("/Product")
public class ProductDao {
    @Inject
    ProductRepository repository;

    //<editor-fold desc="Get">
    /**
     * This gets all entities with this type from the Database and returns a list with them
     * @return a list with all ProductDtos
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Object> getAll() {
        var entities = repository.loadAll();
        return MappingHelper.entityDtoTransformation(entities);
    }
    /**
     * This gets specific entities from this type from the Database and returns a list with them
     * @param name Product name which should be searched
     * @return All entities with this name
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/{name}")
    public List<Object> getByName(String name) {
        var entities = repository.findByName(name);
        return MappingHelper.entityDtoTransformation(entities);
    }
    //</editor-fold>*/
    /**
     * gets an entity from this class by its id
     * @param id the id of the Product to return
     * @return The Product with the id of the input param
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/{id}")
    public Object getById(Integer id) {
        var entity = repository.findById(id);
        return MappingHelper.entityDtoTransformation(entity);
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
    public Response add(ProductDto dto) {
        var entity = MappingHelper.entityDtoTransformation(dto);
        repository.add(entity);
        return Response.status(Response.Status.CREATED).build();
    }
    //</editor-fold>
    //<editor-fold desc="Delete">
    /**
     * Deletes a Product entity by that entities id
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
     * Transforms a dto into a Product and updates it
     * @param dto The dto of the entity
     * @return The JSON Response code
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/update")
    public Response update(ProductDto dto) {
        var entity = MappingHelper.entityDtoTransformation(dto);

        repository.update((Product) entity);
        return Response.status(Response.Status.OK).build();
    }
    //</editor-fold>
}
