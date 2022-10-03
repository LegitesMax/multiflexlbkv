package at.multiflex.dao;

import at.multiflex.model.Color;

import javax.enterprise.context.Dependent;
import javax.ws.rs.Path;

/**
 * This class includes all json requests for the Color class
 */
@Dependent
@Path("/Color")
public class ColorDao  extends GenericDao {
    /**
     * A Constructor that tells the superclass which entity class to use
     */
    public ColorDao() {
        type = Color.class;
    }
}
