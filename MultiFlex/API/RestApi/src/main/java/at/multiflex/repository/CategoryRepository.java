package at.multiflex.repository;

import at.multiflex.model.Category;
import at.multiflex.model.Color;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CategoryRepository extends CRUDOperations{
    @Transactional
    public List<Category> loadAll() {
        return em.createQuery("select x from Category x", Category.class).getResultList();
    }
    @Transactional
    public Category findById(Integer id){
        return em.createQuery("select x from Category x where x.id = :id", Category.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public Category findByName(String name){
        return em.createQuery("select x from Category x where x.name like lower(concat('%', concat(:name, '%')))", Category.class).setParameter("name", name).getSingleResult();
    }
    @Transactional
    public Category findByAcronym(String name){
        return em.createQuery("select x from Category x where x.acronym like lower(concat('%', concat(:name, '%')))", Category.class).setParameter("name", name).getSingleResult();
    }
    @Transactional
    public List<Category> findByProduct(String productName){
        return em.createQuery("select x from Product y join y.category x where x.name = :name", Category.class)
                 .setParameter("name", productName).getResultList();
    }
}
