package at.multiflex.repository.wares;

import at.multiflex.model.Wares.Material;
import at.multiflex.repository.Repository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

/**
 * This class has all Database Queries of the Material class
 */
@ApplicationScoped
public class MaterialRepository extends Repository {
    /**
     * A Query to load all Material entities from the database
     * @return A list with all Material entities from the database
     */
    @Transactional
    public List<Material> loadAll() {
        return em.createQuery("select x from Material x", Material.class).getResultList();
    }
    /**
     * Loads a Material entity from the database
     * @param id The id of the entity to load
     * @return The entity loaded from the database
     */
    @Transactional
    public Material findById(Integer id){
        return em.createQuery("select x from Material x where x.id = :id", Material.class).setParameter("id", id).getSingleResult();
    }
    /**
     * Loads all Material entities from the database with the given name
     * @param name The name of the entity to load
     * @return A list of entities loaded from the database
     */
    @Transactional
    public List<Material> findByName(String name){
        return em.createQuery("select x from Material x where x.name like lower(concat('%', concat(:name, '%')))", Material.class).setParameter("name", name).getResultList();
    }
}
