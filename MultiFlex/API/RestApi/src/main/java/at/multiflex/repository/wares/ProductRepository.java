package at.multiflex.repository.wares;

import at.multiflex.model.Wares.Product;
import at.multiflex.repository.Repository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

/**
 * This class has all Database Queries of the Product class
 */
@ApplicationScoped
public class ProductRepository extends Repository {
    /**
     * A Query to load all Product entities from the database
     * @return A list with all Product entities from the database
     */
    @Transactional
    public List<Product> loadAll() {
        return em.createQuery("select x from Product x", Product.class).getResultList();
    }
    /**
     * Loads a Product entity from the database
     * @param id The id of the entity to load
     * @return The entity loaded from the database
     */
    @Transactional
    public Product findById(Integer id){
        return em.createQuery("select x from Product x where x.id = :id", Product.class).setParameter("id", id).getSingleResult();
    }
    /**
     * Loads all Product entities from the database with the given name
     * @param name The name of the entity to load
     * @return A list of entities loaded from the database
     */
    @Transactional
    public List<Product> findByName(String name){
        return em.createQuery("select x from Product x where x.name like lower(:name)", Product.class).setParameter("name", name).getResultList();
    }
}
