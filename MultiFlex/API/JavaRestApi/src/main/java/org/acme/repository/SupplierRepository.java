package org.acme.repository;

import org.acme.model.Supplier;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SupplierRepository extends CRUDOperations{
    @Inject
    WareRepository repository;

    @Transactional
    public void delete(Supplier s){
        var wares = repository.findBySupplier(s.getName());
        for (var ware : wares) {
            ware.getSuppliers().remove(s);
            update(ware);
        }

        if (s.getWares() != null){
            s.getWares().removeAll(s.getWares());
        }
        update(s);
        remove(s);
    }

    //Queries
    @Transactional
    public List<Supplier> loadAll() {
        return em.createQuery("select l from Supplier l", Supplier.class).getResultList();
    }
    @Transactional
    public Supplier findById(Integer id){
        return em.createQuery("select l from Supplier l where l.id = :id", Supplier.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public List<Supplier> findByName( String name){
        return em.createQuery("select s from Supplier s where s.name like lower(concat('%', concat(:name, '%')))", Supplier.class).setParameter("name", name).getResultList();
    }
}
