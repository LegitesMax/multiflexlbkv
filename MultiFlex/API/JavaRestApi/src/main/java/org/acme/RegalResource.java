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
        setRegals();
        //entityManager.createQuery("select r from Regal r join Fach f on r.regal_id = f.regal_id", Regal.class).getResultList();
        //return entityManager.createQuery("select r from Regal r join Fach f on r.regal_id = f.regal_id").getResultList();
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
        r1.setName("Regal-1");
        r1.setMax_anzahl_faecher(15);

        var r2 = new Regal();
        r2.setName("Regal-2");
        r2.setMax_anzahl_faecher(20);

        entityManager.persist(r1);
        entityManager.persist(r2);
    }

}