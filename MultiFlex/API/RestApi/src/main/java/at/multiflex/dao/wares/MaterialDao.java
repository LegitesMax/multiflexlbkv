package at.multiflex.dao.wares;

import at.multiflex.dao.GenericDao;
import at.multiflex.model.Wares.Material;

import javax.enterprise.context.Dependent;
import javax.ws.rs.Path;

/**
 * This class includes all json requests for the Article class
 */
@Dependent
@Path("/Material")
public class MaterialDao extends GenericDao {
    /**
     * A Constructor that tells the superclass which entity class to use
     */
    public MaterialDao() {
        type = Material.class;
    }
}
