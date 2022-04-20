package org.acme.repository;

import org.acme.model.Regal;
import org.acme.model.Supplier;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

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
    @Transactional
    public List<Supplier> loadByName(@PathParam String name){
        return em.createQuery("select s from Supplier s where s.name like lower(concat('%', concat(:name, '%')))", Supplier.class).setParameter("name", name).getResultList();
    }
}
