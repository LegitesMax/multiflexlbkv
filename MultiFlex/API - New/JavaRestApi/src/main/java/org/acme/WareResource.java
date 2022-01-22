package org.acme;

import org.acme.model.Ware;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/ware")
public class WareResource extends EntitiyManagerObject{

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Ware> getAll() {
        return entityManager.createQuery("select w from Ware w", Ware.class).getResultList();
    }

}
