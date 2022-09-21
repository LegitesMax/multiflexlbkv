package at.multiflex.repository;

import at.multiflex.model.Size;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

/**
 * This class has all Database Queries of the Size class
 */
@ApplicationScoped
public class SizeRepository extends CRUDOperations{
    /**
     * A Query to load all Size entities from the database
     * @return A list with all Size entities from the database
     */
    @Transactional
    public List<Size> loadAll() {
        return em.createQuery("select x from Size x", Size.class).getResultList();
    }
    /**
     * Loads a Size entity from the database
     * @param id The id of the entity to load
     * @return The entity loaded from the database
     */
    @Transactional
    public Size findById(Integer id){
        return em.createQuery("select x from Size x where x.id = :id", Size.class).setParameter("id", id).getSingleResult();
    }
}
