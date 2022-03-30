package org.acme;

import org.acme.model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Produces;
import java.util.List;

@ApplicationScoped
public class InsertManager {
    @Inject
    EntityManager em;

    @Transactional
    public <T> void add(T entity){
        em.persist(entity);}
    @Transactional
    public <T> void remove(T object){
        em.remove(object);
    }
    //@Transactional
    //public void add(Benutzer benutzer){
    //    em.persist(benutzer);}
    //@Transactional
    //public void add(Farbe farbe){
    //    em.persist(farbe);}
    //@Transactional
    //public void add(Regal regal){
    //    em.persist(regal);}
    //@Transactional
    //public void add(Ware ware){
    //    em.persist(ware);}
    @Transactional
    public void add(Fach f, Ware w){
        if (f.getId() == null)
            add(f);
        if (w.getId() == null)
            add(w);

        w.getFächer().add(f);
        f.setWare(w);

        em.persist(w);
        em.persist(f);
    }
    @Transactional
    public void add(Ware w, Fach f){
        add(f, w);
    }
    @Transactional
    public void add(Fach f, Regal r){
        if (f.getId() == null)
            add(f);
        if (r.getId() == null)
            add(r);

        r.getFaecher().add(f);
        f.setRegal(r);

        em.persist(r);
        em.persist(f);
    }
    @Transactional
    public void add(Regal r, Fach f){
        add(f, r);
    }
    @Transactional
    public void add(Farbe f, Ware w){
        if (f.getId() == null)
            add(f);
        if (w.getId() == null)
            add(w);

        w.getFarben().add(f);
        f.getWaren().add(w);

        em.persist(w);
        em.persist(f);
    }
    @Transactional
    public void add(Ware w, Farbe f){
        add(f, w);
    }
    @Transactional
    public void add(Lieferant l, Ware w){
        if (l.getId() == null)
            add(l);
        if (w.getId() == null)
            add(w);

        w.getLieferanten().add(l);
        l.getWaren().add(w);

        em.persist(w);
        em.persist(l);
    }
    @Transactional
    public void add(Ware w, Lieferant l){
        add(l, w);
    }
    public void add(Ware w, Typ t){
        if (w.getId() == null)
            add(w);
        if (t.getId() == null)
            add(t);

        t.getWaren().add(w);
        w.setTyp(t);

        em.persist(t);
        em.persist(w);
    }
    public void add(Typ t, Ware w){
        add(w, t);
    }


        //    return em.createQuery("select b from Benutzer b", Benutzer.class).getResultList();
        //}


    @Transactional
    public List<Benutzer> loadAll(Benutzer b) {
        return em.createQuery("select b from Benutzer b", Benutzer.class).getResultList();
    }
    @Transactional
    public List<Farbe> loadAll(Farbe f) {
        return em.createQuery("select f from Farbe f", Farbe.class).getResultList();
    }
    @Transactional
    public List<Ware> loadAll(Ware w) {
        return em.createQuery("select w from Ware w", Ware.class).getResultList();
    }



    //@Transactional
    //public Benutzer benutzerFindById(Integer id){
    //    return em.createQuery("select b from Benutzer b where b.id = :id", Benutzer.class).setParameter("id", id).getSingleResult();
    //}
    //@Transactional
    //public Farbe farbeFindById(Integer id){
    //    return em.createQuery("select f from Farbe f where f.id = :id", Farbe.class).setParameter("id", id).getSingleResult();
    //}
    //@Transactional
    //public Ware wareFindById(Integer id){
    //    return em.createQuery("select w from Ware w where w.id = :id", Ware.class).setParameter("id", id).getSingleResult();
    //}
}
