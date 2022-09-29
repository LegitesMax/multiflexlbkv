package at.multiflex.dao;

import at.multiflex.dto.CategoryDto;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.mapper.ObjectMapper;
import at.multiflex.model.Category;
import at.multiflex.model.Wares.Product;
import at.multiflex.repository.CategoryRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * This class includes all json requests for the Category class
 */
@Dependent
@Path("/Category")
public class CategoryDao extends GenericDao {

    public CategoryDao() {
        type = Category.class;
    }

}
