package org.acme.dao;

import org.acme.DTO.RegalDto;
import org.acme.InsertManager;
import org.acme.mapper.ObjectMapper;
import org.acme.model.Regal;
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
@Path("/regal")
public class RegalDao {

    @Inject
    EntityManager em;

    @Inject
    ObjectMapper objectMapper;

    @Transactional
    public void add(Regal regal){
        em.persist(regal);}
    @Transactional
    public void remove(Regal regal){
        em.remove(regal);
    }
    @Transactional
    public List<Regal> loadAll() {
        return em.createQuery("select r from Regal r", Regal.class).getResultList();
    }
    @Transactional
    public Regal findById(Integer id){
        return em.createQuery("select r from Regal r where r.id = :id", Regal.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public List<Regal> loadByName(@PathParam String name){
        return em.createQuery("select r from Regal r where r.name like lower(concat('%', concat(:name, '%')))", Regal.class).setParameter("name", name).getResultList();
    }
    @Transactional
    public List<RegalDto> regalToDto(List<Regal> regale){
        var regalDtos = new LinkedList<RegalDto>();
        for(var regal : regale){
            if(regal.getFaecher().size() > 0) {
                var fachSet = regal.getFaecher();
                List<Integer> fachIds = new LinkedList<>();
                for (var fach : fachSet) {
                    fachIds.add(fach.getId());
                }
                Collections.sort(fachIds);
                RegalDto regalDto = new RegalDto(regal.getId(), regal.getName(), regal.getMax_anzahl_faecher(), fachIds);
                regalDtos.add(regalDto);
            }
        }
        return regalDtos;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Transactional
    public List<RegalDto> getAll() {
        //var regale = loadAllRegal();
        var regale = loadAll();
        var regalDtos = regalToDto(regale);
        return regalDtos;
    }
    @GET
    @Path("/{name}")
    @Transactional
    public List<RegalDto> getOne(String name) {
        var regale = loadByName(name);
        var regalDtos = regalToDto(regale);
        return regalDtos;
    }

    @POST
    @Path("/addregal")
    public Response addRegal(RegalDto regalDto) {
        var regal = objectMapper.fromDto(regalDto);
        add(regal);
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
