package org.acme.dao;

import org.acme.DTO.RegalDto;
import org.acme.mapper.RegalMapper;
import org.acme.model.Regal;
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
@Path("/regal")
public class RegalDao {

    @Inject
    EntityManager entityManager;

    //@Inject
    //RegalDao regalDao;

    @Inject
    RegalMapper regalMapper;

    public void add(Regal r) {
        entityManager.persist(r);
    }

    public List<Regal> loadAllRegal() {
        return entityManager.createQuery("select r from Regal r", Regal.class).getResultList();
    }

    public Regal loadOneRegal(String name){
        return entityManager.createQuery("select r from Regal r where r.name = :name", Regal.class).setParameter("name", name).getSingleResult();
    }
    public List<Regal> loadSpecificRegal(@PathParam String name){
        return entityManager.createQuery("select r from Regal r where r.name like lower(concat('%', concat(:name, '%')))", Regal.class).setParameter("name", name).getResultList();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<RegalDto> getAll() {
        var regale = loadAllRegal();
        var regalDtos = regalToDto(regale);
        return regalDtos;
    }
    @GET
    @Path("/{name}")
    public List<RegalDto> getOne(String name) {
        var regale = loadSpecificRegal(name);
        var regalDtos = regalToDto(regale);
        return regalDtos;
    }

    @POST
    @Path("/addregal")
    public Response add(RegalDto regalDto) {
        var regal = regalMapper.dtoToRegal(regalDto);
        //System.out.println(regal.toString());

        //var valid = checkRegalName(regal.getName());
        //if(valid){
        //    regalDao.add(regal);
        //}
        add(regal);
        return Response.status(Response.Status.CREATED).build();
    }

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
}
