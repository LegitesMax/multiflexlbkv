package org.acme.repository;

import org.acme.model.Regal;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class RegalRepository extends CRUDOperations{

    @Transactional
    public List<Regal> loadAll() {
        return em.createQuery("select r from Regal r", Regal.class).getResultList();
    }
    @Transactional
    public Regal findById(Integer id){
        return em.createQuery("select r from Regal r where r.id = :id", Regal.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public List<Regal> loadByName(@PathParam String name){
        return em.createQuery("select r from Regal r where r.name like lower(concat('%', concat(:name, '%')))", Regal.class).setParameter("name", name).getResultList();
    }
}
