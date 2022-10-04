package at.multiflex.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * A class where all repositories are inherited from
 */
@ApplicationScoped
public class Repository {
    /**
     * A Entity Manager
     */
    @Inject
    protected EntityManager em;
}
