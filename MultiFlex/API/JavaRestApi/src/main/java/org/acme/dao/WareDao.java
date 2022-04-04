package org.acme.dao;

import org.acme.DTO.RegalDto;
import org.acme.DTO.WareDto;
import org.acme.InsertManager;
import org.acme.mapper.MappingHelper;
import org.acme.mapper.ObjectMapper;
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
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Dependent
@Path("/ware")
public class WareDao {
    @Inject
    EntityManager em;

    @Inject
    ObjectMapper objectMapper;

    @Inject
    MappingHelper mh;

    @Inject
    InsertManager im;

    @Transactional
    public List<Ware> loadAll() {
        return em.createQuery("select w from Ware w", Ware.class).getResultList();
    }
    @Transactional
    public List<Ware> loadAllProduct() {
        return em.createQuery("select w from Type t join t.wares w where t.type = 'Produkt'", Ware.class).getResultList();
    }
    @Transactional
    public List<Ware> loadAllMaterials() {
        return em.createQuery("select w from Type t join t.wares w where t.type = 'Material'", Ware.class).getResultList();
    }
    @Transactional
    public Ware findById(Integer id){
        return em.createQuery("select w from Ware w where w.id = :id", Ware.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public List<Ware> loadByName(@PathParam String name){
        return em.createQuery("select w from Ware w where w.name like lower(concat('%', concat(:name, '%')))", Ware.class).setParameter("name", name).getResultList();
    }
    @Transactional
    public List<WareDto> regalToDto(List<Ware> waren){
        var wareDtos = new LinkedList<WareDto>();
        for(var ware : waren){
            if(ware.getShelfs().size() > 0) {
                var fachSet = ware.getShelfs();
                List<Integer> fachIds = new LinkedList<>();
                for (var fach : fachSet) {
                    fachIds.add(fach.getId());
                }
                Collections.sort(fachIds);
                var wareDto = new WareDto(ware.getId(), ware.getName(), ware.getStock(), ware.getMinAmount(), ware.getMaxAmount(), fachIds);
                wareDtos.add(wareDto);
            }
        }
        return wareDtos;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Transactional
    public List<WareDto> getAll() {
        //var regale = loadAllRegal();
        var waren = loadAll();
        var wareDtos = regalToDto(waren);
        return wareDtos;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("material")
    @Transactional
    public List<WareDto> getAllMaterials() {
        //var regale = loadAllRegal();
        var waren = loadAllMaterials();
        //var wareDtos = regalToDto(waren);
        //return wareDtos;
        return mh.toDto(waren);
        //return loadAllMaterials();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("product")
    @Transactional
    public List<WareDto> getAllProducts() {
        //var regale = loadAllRegal();
        var waren = loadAllProduct();
        var wareDtos = regalToDto(waren);
        return wareDtos;
    }
    //@GET
    //@Path("/{name}")
    //@Transactional
    //public List<WareDto> getOne(String name) {
    //    var waren = loadByName(name);
    //    var wareDtos = regalToDto(waren);
    //    return wareDtos;
    //}

    @POST
    @Path("/add")
    public Response addRegal(WareDto wareDto) {
        var ware = objectMapper.fromDto(wareDto);
        System.out.println(wareDto.getName());
        im.add(ware);
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
