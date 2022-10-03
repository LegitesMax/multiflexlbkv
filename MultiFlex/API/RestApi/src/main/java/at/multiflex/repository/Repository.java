package at.multiflex.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class Repository {
    @Inject
    protected EntityManager em;
}
