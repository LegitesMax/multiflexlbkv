package org.acme.repository;

import org.acme.model.Type;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TypeRepository extends CRUDOperations{
    @Transactional
    public List<Type> loadAll() {
        return em.createQuery("select t from Type t", Type.class).getResultList();
    }
    public List<Type> loadAllMaterial() {
        return em.createQuery("select t from Type t where t.name like 'Material'", Type.class).getResultList();
    }
    public List<Type> loadAllProduct() {
        return em.createQuery("select t from Type t where t.name like 'Produkt'", Type.class).getResultList();
    }

    @Transactional
    public Type findById(Integer id){
        return em.createQuery("select t from Type t where t.id = :id", Type.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public List<Type> findByName(@PathParam String name){
        return em.createQuery("select t from Type t where t.name like lower(concat('%', concat(:name, '%')))", Type.class).setParameter("name", name).getResultList();
    }
}
