package org.acme.repository;

import org.acme.model.Shelf;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class ShelfRepository extends CRUDOperations{
    @Transactional
    public List<Shelf> loadAll() {
        return em.createQuery("select s from Shelf s", Shelf.class).getResultList();
    }
    @Transactional
    public Shelf findById(Integer id){
        return em.createQuery("select s from Shelf s where s.id = :id", Shelf.class).setParameter("id", id).getSingleResult();
    }
}
