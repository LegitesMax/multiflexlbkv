package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.model.Regal;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class RegalService extends EntityManagerObject implements PanacheRepository<Regal> {


    public List<Regal> loadAllRegal() {

        return list("select r from Regal r");
        //return entityManager.createQuery("select r from Regal r", Regal.class).getResultList();
    }

    public Regal loadOneRegal(String name){
        //return list("select r from Regal r where r.name = :name");
        return entityManager.createQuery("select r from Regal r where r.name = :name", Regal.class).setParameter("name", name).getSingleResult();
    }
}
