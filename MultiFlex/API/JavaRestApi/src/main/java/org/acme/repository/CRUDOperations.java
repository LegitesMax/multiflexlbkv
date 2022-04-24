package org.acme.repository;

import org.acme.model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CRUDOperations {
    @Inject
    EntityManager em;

    @Transactional
    public <T> void add(T entity){
        em.persist(entity);}
    @Transactional
    public <T> void remove(T object){
        em.remove(object);
    }

    @Transactional
    public void add(Shelf f, Ware w){
        if (f.getId() == null)
            add(f);
        if (w.getId() == null)
            add(w);

        w.getShelfs().add(f);
        f.setWare(w);

        em.persist(w);
        em.persist(f);
    }
    @Transactional
    public void add(Ware w, Shelf f){
        add(f, w);
    }
    @Transactional
    public void add(Shelf f, Regal r){
        if (f.getId() == null)
            add(f);
        if (r.getId() == null)
            add(r);

        r.getShelfs().add(f);
        f.setRegal(r);

        em.persist(r);
        em.persist(f);
    }
    @Transactional
    public void add(Regal r, Shelf f){
        add(f, r);
    }
    @Transactional
    public void add(Color f, Ware w){
        if (f.getId() == null)
            add(f);
        if (w.getId() == null)
            add(w);

        w.getColors().add(f);
        f.getWares().add(w);

        em.persist(w);
        em.persist(f);
    }
    @Transactional
    public void add(Ware w, Color f){
        add(f, w);
    }
    @Transactional
    public void add(Supplier l, Ware w){
        if (l.getId() == null)
            add(l);
        if (w.getId() == null)
            add(w);

        w.getSuppliers().add(l);
        l.getWares().add(w);

        em.persist(w);
        em.persist(l);
    }
    @Transactional
    public void add(Ware w, Supplier l){
        add(l, w);
    }
    public void add(Ware w, Type t){
        if (w.getId() == null)
            add(w);
        if (t.getId() == null)
            add(t);

        t.getWares().add(w);
        w.setType(t);

        em.persist(t);
        em.persist(w);
    }
    public void add(Type t, Ware w){
        add(w, t);
    }
}
