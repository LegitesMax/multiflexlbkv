package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.model.Fach;

import java.util.List;

public class FachService extends EntityManagerObject implements PanacheRepository<Fach> {


    public List<Fach> loadAllFach() {

        return list("select f from Fach f");
        //return entityManager.createQuery("select r from Regal r", Regal.class).getResultList();
    }
}
