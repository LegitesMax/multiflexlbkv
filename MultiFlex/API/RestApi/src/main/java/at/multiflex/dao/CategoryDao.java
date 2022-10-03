package at.multiflex.dao;

import at.multiflex.model.Category;

import javax.enterprise.context.Dependent;
import javax.ws.rs.Path;

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
}
