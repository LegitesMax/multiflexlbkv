package org.acme;

import org.acme.mapper.RegalMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class EntityManagerObject {

    @Inject
    EntityManager entityManager;
}
