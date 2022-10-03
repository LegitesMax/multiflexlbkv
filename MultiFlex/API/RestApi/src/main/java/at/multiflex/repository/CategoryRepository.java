package at.multiflex.repository;

import at.multiflex.model.Category;
import at.multiflex.model.Wares.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * This class has all Database Queries of the Category class
 */
@ApplicationScoped
public class CategoryRepository
{
    @Inject
    EntityManager em;
    /**
     * A Query to load all Category entities from the database
     * @return A list with all Category entities from the database
     */
    @Transactional
    public List<Category> loadAll() {
        //var res = em.createQuery("select x from Category x join x.products y where y.name like lower(concat('%', concat(x.acronym, '%')))", Category.class).getResultList();
        var products = em.createQuery("select x from Product x join x.category order by x.name", Product.class).getResultList();
        //System.out.println(res.size());
        var res = em.createQuery("select x from Category x", Category.class).getResultList();

        var newRes = new ArrayList<Category>();
        for (var result:res) {
            result.getProducts().clear();
            for (var product:products) {
                if (product.getName().startsWith(result.getAcronym() + " ")){
                    result.getProducts().add(product);
                }

            }
            newRes.add(result);
        }

        return newRes;
    }
    /**
     * Loads a Category entity from the database
     * @param id The id of the entity to load
     * @return The entity loaded from the database
     */
    @Transactional
    public Category findById(Integer id){
        return em.createQuery("select x from Category x where x.id = :id", Category.class).setParameter("id", id).getSingleResult();
    }
    /**
     * Loads all Category entities from the database with the given name
     * @param name The name of the entity to load
     * @return A list of entities loaded from the database
     */
    @Transactional
    public Category findByName(String name){
        return em.createQuery("select x from Category x where x.name like lower(concat('%', concat(:name, '%')))", Category.class).setParameter("name", name).getSingleResult();
    }
    /**
     * Loads the Category entity from the database with the given acronym
     * @param name An acronym of an entity
     * @return The entity loaded from the database
     */
    @Transactional
    public Category findByAcronym(String name){
        return em.createQuery("select x from Category x where x.acronym like lower(concat('%', concat(:name, '%')))", Category.class).setParameter("name", name).getSingleResult();
    }
}
