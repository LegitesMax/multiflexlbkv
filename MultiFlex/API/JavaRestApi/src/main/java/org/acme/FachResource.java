package org.acme;

import org.acme.model.Fach;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/fach")
public class FachResource extends EntitiyManagerObject {

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Fach> getAll() {
        return entityManager.createQuery("select f from Fach f", Fach.class).getResultList();
    }

}
