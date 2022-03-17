package org.acme.dao;

import org.acme.DTO.LieferantDto;
import org.acme.InsertManager;
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
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Dependent
@Path("/lieferant")
public class LieferantDao {
    @Inject
    EntityManager entityManager;

    @Inject
    ObjectMapper objectMapper;

    InsertManager insertManager;

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
        //var lieferantsDto = new LinkedList<LieferantDto>();
        var lieferants = loadAllRegal();
        var lieferantsDto = lieferantToDto(lieferants);
        return lieferantsDto;
    }

    @POST
    @Path("/addlieferant")
    public Response add(LieferantDto lieferantDto) {
        var lieferant = objectMapper.fromDto(lieferantDto);

        insertManager.add(lieferant);

        return Response.status(Response.Status.CREATED).build();
    }

    public List<LieferantDto> lieferantToDto(List<Lieferant> lieferanten){
        var lieferantDtos = new LinkedList<LieferantDto>();
        for(var lieferant : lieferanten){
            if(lieferant.getMaterialien().size() > 0) {
                var materialSet = lieferant.getMaterialien();
                List<Integer> matherialIds = new LinkedList<>();
                for (var lieferant2 : materialSet) {
                    matherialIds.add(lieferant2.getId());
                }
                Collections.sort(matherialIds);
                LieferantDto lieferantDto = new LieferantDto(lieferant.getId(), lieferant.getName(), lieferant.getWeblink(), lieferant.getLieferzeit(),matherialIds);
                lieferantDtos.add(lieferantDto);
            }
        }
        return lieferantDtos;
    }
}
