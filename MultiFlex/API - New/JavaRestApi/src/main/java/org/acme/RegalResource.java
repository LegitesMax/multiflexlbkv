package org.acme;

import io.smallrye.mutiny.Uni;
import org.acme.model.Fach;
import org.acme.model.Regal;
import org.acme.model.Ware;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/regal")
public class RegalResource extends EntitiyManagerObject{

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Regal> getAll() {
        return entityManager.createQuery("select r from Regal r", Regal.class).getResultList();
    }

    @GET
    @Path("/{name}")
    public Regal getOne(@PathParam String name) {
        return entityManager.createQuery("select r from Regal r where r.name = :name", Regal.class).setParameter("name", name).getSingleResult();
    }
}