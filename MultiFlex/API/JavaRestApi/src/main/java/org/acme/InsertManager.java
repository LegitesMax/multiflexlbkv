package org.acme;

import org.acme.model.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Produces;
import java.util.List;

public class InsertManager {
    @Inject
    EntityManager em;

    @Transactional
    public <T> void add(T entity){
        em.persist(entity);}
    @Transactional
    public void add(Benutzer benutzer){
        em.persist(benutzer);}
    @Transactional
    public void add(Farbe farbe){
        em.persist(farbe);}
    @Transactional
    public void add(Produkt produkt){
        em.persist(produkt);}
    @Transactional
    public void add(Regal regal){
        em.persist(regal);}
    @Transactional
    public void add(Ware ware){
        em.persist(ware);}

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
    public void add(Farbe f, Produkt p){
        if (f.getId() == null)
            add(f);
        if (p.getId() == null)
            add(p);

        p.getFarben().add(f);
        f.getProdukte().add(p);

        em.persist(p);
        em.persist(f);
    }
    @Transactional
    public void add(Material m, Farbe f){
        if (m.getId() == null)
            add(m);
        if (f.getId() == null)
            add(f);

        f.getMaterials().add(m);
        m.setFarbe(f);

        em.persist(f);
        em.persist(m);
    }
    @Transactional
    public void add(Material m, Lieferant f){
        if (m.getId() == null)
            add(m);
        if (f.getId() == null)
            add(f);

        f.getMaterialien().add(m);
        m.getLieferanten().add(f);

        em.persist(f);
        em.persist(m);
    }
    @Transactional
    public void add(Material m, Produkt p){
        if (m.getId() == null)
            add(m);
        if (p.getId() == null)
            add(p);

        p.getMaterialien().add(m);
        m.getProdukte().add(p);

        em.persist(p);
        em.persist(m);
    }

    @Transactional
    public <T> void remove(T object){
        em.remove(object);
     }


    @Transactional
    public List<Benutzer> benutzerLoadAll() {
        return em.createQuery("select b from Benutzer b", Benutzer.class).getResultList();
    }
    @Transactional
    public List<Farbe> farbenLoadAll() {
        return em.createQuery("select f from Farbe f", Farbe.class).getResultList();
    }
    @Transactional
    public List<Produkt> produkteLoadAll() {
        return em.createQuery("select p from Produkt p", Produkt.class).getResultList();
    }
    @Transactional
    public List<Ware> warenLoadAll() {
        return em.createQuery("select w from Ware w", Ware.class).getResultList();
    }



    @Transactional
    public Benutzer benutzerFindById(Integer id){
        return em.createQuery("select b from Benutzer b where b.id = :id", Benutzer.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public Farbe farbeFindById(Integer id){
        return em.createQuery("select f from Farbe f where f.id = :id", Farbe.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public Produkt produktFindById(Integer id){
        return em.createQuery("select p from Produkt p where p.id = :id", Produkt.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public Ware wareFindById(Integer id){
        return em.createQuery("select w from Ware w where w.id = :id", Ware.class).setParameter("id", id).getSingleResult();
    }
}
