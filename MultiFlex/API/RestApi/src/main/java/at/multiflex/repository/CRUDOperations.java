package at.multiflex.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * This class has all CRUD (Create, Update, Delete) operations
 */
@ApplicationScoped
public class CRUDOperations {
    @Inject
    protected EntityManager em;

    /**
     * A generic method to add an entity
     * @param entity a generic entity to insert into the database
     * @param <T> the generic type T
     */
    @Transactional
    public<T> void add(T entity){
        if(entity == null) throw new IllegalArgumentException();
        em.persist(entity);
    }
    /**
     * A generic method to delete an entity
     * @param entity a generic entity to delete from the database
     * @param <T> the generic type T
     */
    @Transactional
    public<T> void delete(T entity){
        if(entity == null) throw new IllegalArgumentException();
        em.remove(entity);
    }
    /**
     * A generic method to update an entity
     * @param entity a generic entity to update from the database
     * @param <T> the generic type T
     */
    @Transactional
    public<T> void update(T entity){
        if(entity == null) throw new IllegalArgumentException();
        em.merge(entity);
    }
}
