package org.acme.dao;

import org.acme.DTO.LieferantDto;
import org.acme.DTO.MaterialDto;
import org.acme.mapper.LieferantMapper;
import org.acme.mapper.ObjectMapper;
import org.acme.model.Lieferant;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Dependent
@Path("/lieferant")
public class LieferantDao {
    @Inject
    EntityManager entityManager;

    //@Inject
    //RegalDao regalDao;

    @Inject
    ObjectMapper objectMapper;

    public void add(Lieferant l) {
        entityManager.persist(l);
    }

    public List<Lieferant> loadAllRegal() {
        return entityManager.createQuery("select l from Lieferant l", Lieferant.class).getResultList();
    }

    public Lieferant loadOneRegal(String name){
        return entityManager.createQuery("select l from Lieferant l where l.name = :name", Lieferant.class).setParameter("name", name).getSingleResult();
    }
    public List<Lieferant> loadSpecificRegal(@PathParam String name){
        return entityManager.createQuery("select l from Lieferant l where l.name like lower(concat('%', concat(:name, '%')))", Lieferant.class).setParameter("name", name).getResultList();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<LieferantDto> getAll() {
        var lieferantsDto = new LinkedList<LieferantDto>();
        var lieferants = loadAllRegal();
        for (var lieferant : lieferants){
            lieferantsDto.add(objectMapper.toDTO(lieferant));
        }
        return lieferantsDto;
    }

    @POST
    @Path("/addlieferant")
    public Response add(LieferantDto lieferantDto) {
        var lieferant = objectMapper.fromDto(lieferantDto);

        add(lieferant);

        return Response.status(Response.Status.CREATED).build();
    }
}
