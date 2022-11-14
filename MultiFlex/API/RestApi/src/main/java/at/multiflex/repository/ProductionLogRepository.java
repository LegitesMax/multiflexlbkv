package at.multiflex.repository;

import at.multiflex.model.ProductionLog;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

/**
 * This class has all Database Queries of the ProductionLog class
 */
@ApplicationScoped
public class ProductionLogRepository extends Repository{
    /**
     * A Query to load all ProductionLog entities from the database
     * @return A list with all ProductionLog entities from the database
     */
    @Transactional
    public List<ProductionLog> loadAll() {
        return em.createQuery("select x from ProductionLog x", ProductionLog.class).getResultList();
    }
    /**
     * Loads a ProductionLog entity from the database
     * @param id The id of the entity to load
     * @return The entity loaded from the database
     */
    @Transactional
    public ProductionLog findById(Integer id){
        return em.createQuery("select x from ProductionLog x where x.id = :id", ProductionLog.class).setParameter("id", id).getSingleResult();
    }
}
