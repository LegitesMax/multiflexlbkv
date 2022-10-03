package at.multiflex.dao;

import at.multiflex.model.Size;

import javax.enterprise.context.Dependent;
import javax.ws.rs.Path;

/**
 * This class includes all json requests for the Size class
 */
@Dependent
@Path("/Size")
public class SizeDao extends GenericDao{
    /**
     * A Constructor that tells the superclass which entity class to use
     */
    public SizeDao() {
        type = Size.class;
    }
}
