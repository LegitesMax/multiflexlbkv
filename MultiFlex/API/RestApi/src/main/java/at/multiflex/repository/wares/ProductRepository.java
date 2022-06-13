package at.multiflex.repository.wares;

import at.multiflex.model.Wares.Product;
import at.multiflex.repository.CRUDOperations;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductRepository extends CRUDOperations {
    @Transactional
    public List<Product> loadAll() {
        return em.createQuery("select x from Product x", Product.class).getResultList();
    }
    @Transactional
    public Product findById(Integer id){
        return em.createQuery("select x from Product x where x.id = :id", Product.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public List<Product> findByName(String name){
        return em.createQuery("select x from Product x where x.name like lower(concat('%', concat(:name, '%')))", Product.class).setParameter("name", name).getResultList();
    }
    @Transactional
    public List<Product> findByCategory(String name){
        return em.createQuery("select x from Category y join y.products x where y.name like lower(concat('%', concat(:name, '%')))", Product.class)
                 .setParameter("name", name).getResultList();
    }
}
