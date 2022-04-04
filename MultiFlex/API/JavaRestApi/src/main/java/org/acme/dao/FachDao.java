package org.acme.dao;

import org.acme.DTO.ShelfDto;
import org.acme.InsertManager;
import org.acme.mapper.ObjectMapper;
import org.acme.model.Shelf;
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
    public List<Shelf> loadAll() {
        return em.createQuery("select s from Shelf s", Shelf.class).getResultList();
    }
    @Transactional
    public Shelf findById(Integer id){
        return em.createQuery("select s from Shelf s where s.id = :id", Shelf.class).setParameter("id", id).getSingleResult();
    }

    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<ShelfDto> getAll() {
        var fachDtos = new LinkedList<ShelfDto>();
        //var faecher = entityManager.createQuery("select f from Shelf f", Shelf.class).getResultList();
        var faecher = loadAll();
        for(var fach : faecher){
            ShelfDto fachDto = new ShelfDto(fach.getId(), fach.getPosition(), fach.getMaxAmount(), fach.getWare().getId(), fach.getRegal().getId());
            fachDtos.add(fachDto);
        }
        return fachDtos;
    }

    @POST
    @Path("/add")
    public Response add(ShelfDto fachDto) {
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
    //    var faecher = em.createQuery("select f from Shelf f", Shelf.class).getResultList();
    //    var regalfachwaren = new LinkedList<RegalFachWare>();
    //    for (var fach : faecher) {
    //        //var regal = em.createQuery("select f.regal from Shelf f", Regal.class).getSingleResult();
    //        var waren  = fach.getWare(); //= em.createQuery("select w from Shelf f join f.ware w", Ware.class).getResultList();
    //        for(var ware : waren){
    //            var regalfachware = new RegalFachWare(fach.getRegal().getName(), fach.getRegal().getMax_anzahl_faecher(), fach.getId(), ware.getName(), ware.getBestand(), ware.getMinbestand(), ware.getMaxbestand());
    //            regalfachwaren.add(regalfachware);
    //        }
    //    }
    //    //var regale = em.createQuery("select r from Shelf f join f.regal r", Regal.class).getResultList();
//
    //    //var regalDtos = regalToDto(regale);
    //    return regalfachwaren;
    //}
}
