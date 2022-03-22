package org.acme.dao;

import org.acme.DTO.TypDto;
import org.acme.DTO.WareDto;
import org.acme.mapper.ObjectMapper;
import org.acme.model.Typ;
import org.acme.model.Ware;
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
@Path("/typ")
public class TypDao {
    @Inject
    EntityManager em;

    @Inject
    ObjectMapper objectMapper;

    @Transactional
    public void add(Typ typ){
        em.persist(typ);}
    @Transactional
    public void remove(Typ typ){
        em.remove(typ);
    }
    @Transactional
    public List<Typ> loadAll() {
        return em.createQuery("select t from Typ t", Typ.class).getResultList();
    }
    @Transactional
    public Typ findById(Integer id){
        return em.createQuery("select t from Typ t where t.id = :id", Typ.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public List<Typ> loadByName(@PathParam String name){
        return em.createQuery("select t from Typ t where t.typ like lower(concat('%', concat(:name, '%')))", Typ.class).setParameter("name", name).getResultList();
    }
    //@Transactional
    //public List<TypDto> regalToDto(List<Typ> waren){
    //    var wareDtos = new LinkedList<WareDto>();
    //    for(var ware : waren){
    //        if(ware.getFächer().size() > 0) {
    //            var fachSet = ware.getFächer();
    //            List<Integer> fachIds = new LinkedList<>();
    //            for (var fach : fachSet) {
    //                fachIds.add(fach.getId());
    //            }
    //            Collections.sort(fachIds);
    //            var wareDto = new WareDto(ware.getId(), ware.getName(), ware.getBestand(), ware.getMinbestand(), ware.getMaxbestand(), fachIds);
    //            wareDtos.add(wareDto);
    //        }
    //    }
    //    return wareDtos;
    //}

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Transactional
    public List<TypDto> getAll() {
        //var regale = loadAllRegal();
        var typDtos = new LinkedList<TypDto>();
        var typen = loadAll();
        for (var typ: typen) {
            typDtos.add(objectMapper.toDTO(typ));
        }
        return typDtos;
    }
    @GET
    @Path("/{name}")
    @Transactional
    public List<TypDto> getOne(String name) {
        var typDtos = new LinkedList<TypDto>();
        var typen = loadAll();
        for (var typ: typen) {
            typDtos.add(objectMapper.toDTO(typ));
        }
        return typDtos;
    }

    @POST
    @Path("/add")
    public Response addRegal(TypDto typDto) {
        var typ = objectMapper.fromDto(typDto);
        //System.out.println(typDto.getName());
        add(typ);
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
