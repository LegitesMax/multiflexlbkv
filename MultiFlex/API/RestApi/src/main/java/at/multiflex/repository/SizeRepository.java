package at.multiflex.repository;

import at.multiflex.model.Category;
import at.multiflex.model.Size;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SizeRepository extends CRUDOperations{
    @Transactional
    public List<Size> loadAll() {
        return em.createQuery("select x from Size x", Size.class).getResultList();
    }
    @Transactional
    public Size findById(Integer id){
        return em.createQuery("select x from Size x where x.id = :id", Size.class).setParameter("id", id).getSingleResult();
    }
}
