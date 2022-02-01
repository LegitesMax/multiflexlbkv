package org.acme;

import org.acme.model.Regal;
import org.mapstruct.Mapping;

import java.util.List;

public class RegalService extends EntitiyManagerObject{

    public List<Regal> loadAllRegal() {
        return entityManager.createQuery("select r from Regal r", Regal.class).getResultList();
    }

}
