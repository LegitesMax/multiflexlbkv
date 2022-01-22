package org.acme;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class EntitiyManagerObject {
    @Inject
    EntityManager entityManager;
}
