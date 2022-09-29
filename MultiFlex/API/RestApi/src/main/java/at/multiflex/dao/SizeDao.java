package at.multiflex.dao;

import at.multiflex.dto.SizeDto;
import at.multiflex.mapper.ObjectMapper;
import at.multiflex.model.Category;
import at.multiflex.model.Size;
import at.multiflex.repository.SizeRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * This class includes all json requests for the Size class
 */
@Dependent
@Path("/Size")
public class SizeDao extends GenericDao{
    public SizeDao() {
        type = Size.class;
    }
}
