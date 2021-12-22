package org.acme;

import io.quarkus.vertx.http.runtime.devmode.Json;
import io.vertx.core.json.JsonArray;
import org.acme.model.Regal;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;

@Path("/hello")
public class GreetingResource {

    @Inject
    EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public Regal[] hello() {
        return getAllRegals();
    }

    @Transactional
    public Regal[] getAllRegals(){

        var r1 = new Regal();
        r1.setName("Test Regal");
        r1.setMax_anzahl_fächer(10);

        entityManager.persist(r1);

        var result = entityManager.createQuery("select r from Regal r", Regal.class).getResultList();
        return result.toArray(new Regal[result.size()]);
    }

}