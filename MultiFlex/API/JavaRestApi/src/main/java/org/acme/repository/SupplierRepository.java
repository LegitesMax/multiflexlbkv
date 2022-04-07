package org.acme.repository;

import org.acme.model.Supplier;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SupplierRepository extends CRUDOperations{
    @Transactional
    public List<Supplier> loadAll() {
        return em.createQuery("select l from Supplier l", Supplier.class).getResultList();
    }
    @Transactional
    public Supplier findById(Integer id){
        return em.createQuery("select l from Supplier l where l.id = :id", Supplier.class).setParameter("id", id).getSingleResult();
    }
}
