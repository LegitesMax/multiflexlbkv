package at.multiflex.repository.wares;

import at.multiflex.model.Wares.Article;
import at.multiflex.repository.CRUDOperations;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ArticleRepository extends CRUDOperations {
    @Transactional
    public List<Article> loadAll() {
        return em.createQuery("select x from Article x", Article.class).getResultList();
    }
    @Transactional
    public Article findById(Integer id){
        return em.createQuery("select x from Article x where x.id = :id", Article.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public List<Article> findByName(String name){
        return em.createQuery("select x from Article x where x.name like lower(concat('%', concat(:name, '%')))", Article.class).setParameter("name", name).getResultList();
    }
}
