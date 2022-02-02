package org.acme;

import org.acme.model.Regal;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class RegalService extends EntityManagerObject {


    public List<Regal> loadAllRegal() {

        return entityManager.createQuery("select r from Regal r", Regal.class).getResultList();
    }

    public Regal loadOneRegal(String name){
        return entityManager.createQuery("select r from Regal r where r.name = :name", Regal.class).setParameter("name", name).getSingleResult();
    }

}
