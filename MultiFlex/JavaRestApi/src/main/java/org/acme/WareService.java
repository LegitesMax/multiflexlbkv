package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.model.Regal;
import org.acme.model.Ware;

import java.util.List;

public class WareService extends EntityManagerObject implements PanacheRepository<Ware> {

    public List<Ware> loadAllWare() {
        return list("select w from Ware w");
    }

}
