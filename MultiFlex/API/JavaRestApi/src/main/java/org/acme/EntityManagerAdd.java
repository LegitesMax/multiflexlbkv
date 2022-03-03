package org.acme;

import org.acme.model.Fach;
import org.acme.model.Regal;

import javax.transaction.Transactional;

public class EntityManagerAdd extends EntityManagerObject{
    @Transactional
    public void add(Regal r) { entityManager.persist(r);  }

    @Transactional
    public void add(Fach f) { entityManager.persist(f);  }

    @Transactional
    public void add(Fach f, Regal r) {
        add(r, f);
    }

    @Transactional
    public void add(Regal r, Fach f) {
        if(r.getId() == null) {
            add(r);
        }
        if(f.getId() == null) {
            add(f);
        }

        f.setRegal(r);
        r.getFaecher().add(f);

        entityManager.persist(f);
        entityManager.persist(r);
    }
}
