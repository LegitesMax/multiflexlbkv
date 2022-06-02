package at.multiflex.repository.wares;

import at.multiflex.model.Wares.Material;
import at.multiflex.repository.CRUDOperations;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class MaterialRepository extends CRUDOperations {
    @Transactional
    public List<Material> loadAll() {
        return em.createQuery("select x from Material x", Material.class).getResultList();
    }
    @Transactional
    public Material findById(Integer id){
        return em.createQuery("select x from Material x where x.id = :id", Material.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public List<Material> findByName(String name){
        return em.createQuery("select x from Material x where x.name like lower(concat('%', concat(:name, '%')))", Material.class).setParameter("name", name).getResultList();
    }
}
