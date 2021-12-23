package org.acme;

import io.smallrye.mutiny.Uni;
import org.acme.model.Regal;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/regal-overview")
public class RegalResource {

    @Inject
    EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Regal> getAll() {
        setRegals();
        return entityManager.createQuery("select r from Regal r", Regal.class).getResultList();
    }

    @GET
    @Path("/{name}")
    public Regal getOne(@PathParam String name) {
        return entityManager.createQuery("select r from Regal r where r.name = :name", Regal.class).setParameter("name", name).getSingleResult();
    }

    @Transactional
    public void setRegals(){
        var r1 = new Regal();
        r1.setName("Test1");
        r1.setMax_anzahl_fächer(10);

        var r2 = new Regal();
        r2.setName("Test2");
        r2.setMax_anzahl_fächer(20);

        entityManager.persist(r1);
        entityManager.persist(r2);
    }

}