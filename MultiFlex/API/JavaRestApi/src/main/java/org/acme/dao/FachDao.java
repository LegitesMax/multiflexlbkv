package org.acme.dao;

import org.acme.DTO.FachDto;
import org.acme.DTO.QueryModels.RegalFach;
import org.acme.DTO.QueryModels.RegalFachWare;
import org.acme.InsertManager;
import org.acme.mapper.ObjectMapper;
import org.acme.model.Fach;
import org.acme.model.Regal;
import org.acme.model.Ware;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Dependent
@Path("/fach")
public class FachDao {
    @Inject
    EntityManager em;

    @Inject
    ObjectMapper objectMapper;

    @Inject
    InsertManager im;

    @Transactional
    public List<Fach> loadAll() {
        return em.createQuery("select f from Fach f", Fach.class).getResultList();
    }
    @Transactional
    public Fach findById(Integer id){
        return em.createQuery("select f from Fach f where f.id = :id", Fach.class).setParameter("id", id).getSingleResult();
    }

    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<FachDto> getAll() {
        var fachDtos = new LinkedList<FachDto>();
        //var faecher = entityManager.createQuery("select f from Fach f", Fach.class).getResultList();
        var faecher = loadAll();
        for(var fach : faecher){
            FachDto fachDto = new FachDto(fach.getId(), fach.getPosition(), fach.getMaxbestand(), fach.getWare().getId(), fach.getRegal().getId());
            fachDtos.add(fachDto);
        }
        return fachDtos;
    }

    @POST
    @Path("/add")
    public Response add(FachDto fachDto) {
        var fach = objectMapper.fromDto(fachDto);

        im.add(fach);
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
        im.remove(entity);
    }

    //@GET
    //@Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    //@Path("/queries/regal-fach-ware")
    //@Transactional
    //public List<RegalFachWare> getAllWithFach() {
    //    var faecher = em.createQuery("select f from Fach f", Fach.class).getResultList();
    //    var regalfachwaren = new LinkedList<RegalFachWare>();
    //    for (var fach : faecher) {
    //        //var regal = em.createQuery("select f.regal from Fach f", Regal.class).getSingleResult();
    //        var waren  = fach.getWare(); //= em.createQuery("select w from Fach f join f.ware w", Ware.class).getResultList();
    //        for(var ware : waren){
    //            var regalfachware = new RegalFachWare(fach.getRegal().getName(), fach.getRegal().getMax_anzahl_faecher(), fach.getId(), ware.getName(), ware.getBestand(), ware.getMinbestand(), ware.getMaxbestand());
    //            regalfachwaren.add(regalfachware);
    //        }
    //    }
    //    //var regale = em.createQuery("select r from Fach f join f.regal r", Regal.class).getResultList();
//
    //    //var regalDtos = regalToDto(regale);
    //    return regalfachwaren;
    //}
}
