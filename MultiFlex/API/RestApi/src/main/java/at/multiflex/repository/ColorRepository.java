package at.multiflex.repository;

import at.multiflex.model.Color;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ColorRepository extends CRUDOperations {
    @Transactional
    public List<Color> loadAll() {
        return em.createQuery("select x from Color x", Color.class).getResultList();
    }
    @Transactional
    public Color findById(Integer id){
        return em.createQuery("select x from Color x where x.id = :id", Color.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public List<Color> findByName(String name){
        return em.createQuery("select x from Color x where x.name like lower(concat('%', concat(:name, '%')))", Color.class).setParameter("name", name).getResultList();
    }
}
