package org.acme.dao;

import org.acme.model.Regal;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Dependent
public class RegalDao {

    @Inject
    EntityManager entityManager;


    public void add(Regal r) {
        entityManager.persist(r);
    }

    public List<Regal> loadAllRegal() {
        return entityManager.createQuery("select r from Regal r", Regal.class).getResultList();
    }

    public Regal loadOneRegal(String name){
        return entityManager.createQuery("select r from Regal r where r.name = :name", Regal.class).setParameter("name", name).getSingleResult();
    }

}
