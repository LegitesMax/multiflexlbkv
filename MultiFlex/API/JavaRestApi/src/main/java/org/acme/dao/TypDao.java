package org.acme.dao;

import org.acme.DTO.Type;
import org.acme.InsertManager;
import org.acme.mapper.ObjectMapper;
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
@Path("/typ")
public class TypDao {
    @Inject
    EntityManager em;

    @Inject
    ObjectMapper objectMapper;

    @Inject
    InsertManager im;

    @Transactional
    public List<org.acme.model.Type> loadAll() {
        return em.createQuery("select t from Type t", org.acme.model.Type.class).getResultList();
    }
    public List<org.acme.model.Type> loadAllWare() {
        return em.createQuery("select t from Type t where t.typ like 'Ware'", org.acme.model.Type.class).getResultList();
    }
    public List<org.acme.model.Type> loadAllProduct() {
        return em.createQuery("select t from Type t where t.typ like 'Produkt'", org.acme.model.Type.class).getResultList();
    }

    @Transactional
    public org.acme.model.Type findById(Integer id){
        return em.createQuery("select t from Type t where t.id = :id", org.acme.model.Type.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public List<org.acme.model.Type> loadByName(@PathParam String name){
        return em.createQuery("select t from Type t where t.typ like lower(concat('%', concat(:name, '%')))", org.acme.model.Type.class).setParameter("name", name).getResultList();
    }
    //@Transactional
    //public List<Type> regalToDto(List<Type> waren){
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
    public List<Type> getAll() {
        //var regale = loadAllRegal();
        var typDtos = new LinkedList<Type>();
        var typen = loadAll();
        for (var typ: typen) {
            typDtos.add(objectMapper.toDTO(typ));
        }
        return typDtos;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Transactional
    @Path("/Ware")
    public List<Type> getAllWare() {
        //var regale = loadAllRegal();
        var typDtos = new LinkedList<Type>();
        var typen = loadAllWare();
        for (var typ: typen) {
            typDtos.add(objectMapper.toDTO(typ));
        }
        return typDtos;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/Product")
    @Transactional
    public List<Type> getAllProduct() {
        //var regale = loadAllRegal();
        var typDtos = new LinkedList<Type>();
        var typen = loadAllProduct();
        for (var typ: typen) {
            typDtos.add(objectMapper.toDTO(typ));
        }
        return typDtos;
    }
    /*
    @GET
    @Path("/{name}")
    @Transactional
    public List<Type> getOne(String name) {
        var typDtos = new LinkedList<Type>();
        var typen = loadAll();
        for (var typ: typen) {
            typDtos.add(objectMapper.toDTO(typ));
        }
        return typDtos;
    }
     */

    @POST
    @Path("/add")
    public Response addRegal(Type type) {
        var typ = objectMapper.fromDto(type);
        //System.out.println(type.getName());
        im.add(typ);
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
}
