package org.acme.dao;

import org.acme.DTO.LieferantDto;
import org.acme.InsertManager;
import org.acme.mapper.ObjectMapper;
import org.acme.model.Lieferant;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Dependent
@Path("/lieferant")
public class LieferantDao {
    @Inject
    EntityManager em;

    @Inject
    ObjectMapper objectMapper;

    @Transactional
    public void add(Lieferant lieferant){
        em.persist(lieferant);}
    @Transactional
    public void remove(Lieferant lieferant){
        em.remove(lieferant);
    }
    @Transactional
    public List<Lieferant> loadAll() {
        return em.createQuery("select l from Lieferant l", Lieferant.class).getResultList();
    }
    @Transactional
    public Lieferant findById(Integer id){
        return em.createQuery("select l from Lieferant l where l.id = :id", Lieferant.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
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
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Transactional
    public List<LieferantDto> getAll() {
        //var lieferantsDto = new LinkedList<LieferantDto>();
        //var lieferants = loadAllRegal();
        var lieferants = loadAll();
        var lieferantsDto = lieferantToDto(lieferants);
        return lieferantsDto;
    }

    @POST
    @Path("/addlieferant")
    public Response add(LieferantDto lieferantDto) {
        var lieferant = objectMapper.fromDto(lieferantDto);

        add(lieferant);

        return Response.status(Response.Status.CREATED).build();
    }
    @Transactional
    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Integer id) {
        var entity = findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        remove(entity);
    }
}
