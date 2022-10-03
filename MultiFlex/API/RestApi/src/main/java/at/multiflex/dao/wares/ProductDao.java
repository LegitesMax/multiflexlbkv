package at.multiflex.dao.wares;

import at.multiflex.dao.DaoException;
import at.multiflex.dao.GenericDao;
import at.multiflex.dto.SizeDto;
import at.multiflex.dto.wares.ProductDto;
import at.multiflex.model.Wares.Product;
import org.jboss.resteasy.reactive.RestPath;

import javax.enterprise.context.Dependent;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

    @POST
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/add")
    public Response add(Product dto) throws DaoException {
        return super.add(dto);
    }
}
