package at.multiflex.repository.wares;

import at.multiflex.model.Wares.Article;
import at.multiflex.repository.CRUDOperations;
import at.multiflex.repository.Repository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * This class has all Database Queries of the Article class
 */
@ApplicationScoped
public class ArticleRepository extends Repository implements PanacheRepository<Article> {
    /**
     * A Query to load all Article entities from the database
     * @return A list with all Article entities from the database
     */
    @Transactional
    public List<Article> loadAll() {
        return em.createQuery("select x from Article x", Article.class).getResultList();

    }
    /**
     * Loads an Article entity from the database
     * @param id The id of the entity to load
     * @return The entity loaded from the database
     */
    @Transactional
    public Article findById(Integer id){
        return em.createQuery("select x from Article x where x.id = :id", Article.class).setParameter("id", id).getSingleResult();
    }

    /**
     * Loads all Article entities from the database with the given name
     * @param name The name of the entity to load
     * @return A list of entities loaded from the database
     */
    @Transactional
    public List<Article> findByName(String name){
        return em.createQuery("select x from Article x where x.name like lower(concat('%', concat(:name, '%')))", Article.class).setParameter("name", name).getResultList();
    }
}
