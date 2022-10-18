package at.multiflex.dao;

import at.multiflex.mapper.MappingHelper;
import at.multiflex.model.Category;
import at.multiflex.model.Color;
import at.multiflex.model.Size;
import at.multiflex.model.Wares.Article;
import at.multiflex.model.Wares.Material;
import at.multiflex.model.Wares.Product;
import at.multiflex.repository.CategoryRepository;

import javax.enterprise.context.Dependent;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * This class includes all json requests for the Category class
 */
@Dependent
@Path("/Category")
public class CategoryDao extends GenericDao {
    /**
     * A Constructor that tells the superclass which entity class to use
     */
    public CategoryDao() {
        type = Category.class;
    }

    /**
     * Returns all Products by categories
     * @return The resulting List
     */
    @Path("/Product")
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Object> getAllProducts() {
        var entities = categoryRepository.loadAllProducts();

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
        var entities = categoryRepository.loadAllMaterials();

        return MappingHelper.entityDtoTransformation(entities);
    }

}
