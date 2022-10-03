package at.multiflex.dao.wares;

import at.multiflex.dao.GenericDao;
import at.multiflex.model.Wares.Product;

import javax.enterprise.context.Dependent;
import javax.ws.rs.Path;

/**
 * This class includes all json requests for the Article class
 */
@Dependent
@Path("/Product")
public class ProductDao extends GenericDao {
    /**
     * A Constructor that tells the superclass which entity class to use
     */
    public ProductDao() {
        type = Product.class;
    }
}
