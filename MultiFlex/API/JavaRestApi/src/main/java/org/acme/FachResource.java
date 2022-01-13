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
        setFach();
        return entityManager.createQuery("select f from Fach f", Fach.class).getResultList();
    }

    @Transactional
    public void setFach(){
        var f1 = new Fach();
        f1.setPosition(1);
        f1.setRegal_id(1);
        f1.setWare_id(1);
        f1.setMaxbestand(20);

        var f2 = new Fach();
        f2.setPosition(1);
        f2.setRegal_id(1);
        f2.setWare_id(2);
        f2.setMaxbestand(20);

        var f3 = new Fach();
        f3.setPosition(1);
        f3.setRegal_id(2);
        f3.setWare_id(3);
        f3.setMaxbestand(20);

        entityManager.persist(f1);
        entityManager.persist(f2);
        entityManager.persist(f3);
    }

}
