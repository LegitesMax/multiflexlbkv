package org.acme.repository;

import org.acme.model.Ware;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class WareRepository extends CRUDOperations {
    @Transactional
    public List<Ware> loadAll() {
        return em.createQuery("select w from Ware w", Ware.class).getResultList();
    }
    @Transactional
    public List<Ware> loadAllProduct() {
        return em.createQuery("select w from Type t join t.wares w where t.name = 'Produkt'", Ware.class).getResultList();
    }
    @Transactional
    public List<Ware> loadAllMaterials() {
        return em.createQuery("select w from Type t join t.wares w where t.name = 'Material'", Ware.class).getResultList();
    }
    @Transactional
    public Ware findById(Integer id){
        return em.createQuery("select w from Ware w where w.id = :id", Ware.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public List<Ware> findByName(String name){
        return em.createQuery("select w from Ware w where w.name like lower(concat('%', concat(:name, '%')))", Ware.class).setParameter("name", name).getResultList();
    }
    @Transactional
    public List<Ware> findBySupplier(String name){
        return em.createQuery("select w from Supplier s join s.wares w where s.name like :name", Ware.class).setParameter("name", name).getResultList();
    }
}
