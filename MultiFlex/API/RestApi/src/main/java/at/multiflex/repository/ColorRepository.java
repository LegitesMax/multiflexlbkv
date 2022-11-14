package at.multiflex.repository;

import at.multiflex.model.Color;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

/**
 * This class has all Database Queries of the Category class
 */
@ApplicationScoped
public class ColorRepository extends Repository{
    /**
     * A Query to load all Color entities from the database
     * @return A list with all Color entities from the database
     */
    @Transactional
    public List<Color> loadAll() {
        return em.createQuery("select x from Color x", Color.class).getResultList();
    }
    /**
     * Loads a Color entity from the database
     * @param id The id of the entity to load
     * @return The entity loaded from the database
     */
    @Transactional
    public Color findById(Integer id){
        return em.createQuery("select x from Color x where x.id = :id", Color.class).setParameter("id", id).getSingleResult();
    }
    /**
     * Loads all Color entities from the database with the given name
     * @param name The name of the entity to load
     * @return A list of entities loaded from the database
     */
    @Transactional
    public Color findByName(String name){
        return em.createQuery("select x from Color x where x.name like lower(concat('%', concat(:name, '%')))", Color.class).setParameter("name", name).getSingleResult();
    }
    @Transactional
    public Color findByColorCode(String colorCode){
        return em.createQuery("select x from Color x where x.colorCode like :colorCode", Color.class).setParameter("colorCode", colorCode).getSingleResult();
    }
}
