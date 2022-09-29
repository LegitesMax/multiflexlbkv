package at.multiflex.dao.wares;

import at.multiflex.dao.GenericDao;
import at.multiflex.dto.wares.ProductDto;
import at.multiflex.model.Wares.Product;
import org.jboss.resteasy.reactive.RestPath;

import javax.enterprise.context.Dependent;
import javax.ws.rs.*;
import java.util.List;

/**
 * This class includes all json requests for the Article class
 */
@Dependent
@Path("/Product")
public class ProductDao extends GenericDao {

    public ProductDao() {
        type = Product.class;
    }
}
