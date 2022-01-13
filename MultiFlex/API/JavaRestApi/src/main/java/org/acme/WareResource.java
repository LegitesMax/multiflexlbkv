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
        setWare();
        return entityManager.createQuery("select w from Ware w", Ware.class).getResultList();
    }

    @Transactional
    public void setWare(){
        var r1 = new Ware();
        r1.setBestand(7);
        r1.setMinbestand(4);
        r1.setMaxbestand(20);
        r1.setName("LBXXXX");

        var r2 = new Ware();
        r2.setBestand(11);
        r2.setMinbestand(2);
        r2.setMaxbestand(15);
        r2.setName("BAXXXX");

        var r3 = new Ware();
        r3.setBestand(5);
        r3.setMinbestand(1);
        r3.setMaxbestand(10);
        r3.setName("LÖXXXX");

        entityManager.persist(r1);
        entityManager.persist(r2);
        entityManager.persist(r3);
    }
}
