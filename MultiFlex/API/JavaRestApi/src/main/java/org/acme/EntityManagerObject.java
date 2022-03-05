package org.acme;

import org.acme.model.Fach;
import org.acme.model.Regal;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class EntityManagerObject {

    @Inject
    EntityManager entityManager;
}
