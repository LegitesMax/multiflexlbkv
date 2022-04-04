package org.acme.dao;

import org.acme.DTO.SupplierDto;
import org.acme.InsertManager;
import org.acme.mapper.ObjectMapper;
import org.acme.model.Supplier;
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

    @Inject
    InsertManager im;

    @Transactional
    public List<Supplier> loadAll() {
        return em.createQuery("select l from Supplier l", Supplier.class).getResultList();
    }
    @Transactional
    public Supplier findById(Integer id){
        return em.createQuery("select l from Supplier l where l.id = :id", Supplier.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public List<SupplierDto> lieferantToDto(List<Supplier> lieferanten){
        var lieferantDtos = new LinkedList<SupplierDto>();
        for(var lieferant : lieferanten){
            if(lieferant.getWares().size() > 0) {
                var materialSet = lieferant.getWares();
                List<Integer> warenIds = new LinkedList<>();
                for (var lieferant2 : materialSet) {
                    warenIds.add(lieferant2.getId());
                }
                Collections.sort(warenIds);
                var lieferantDto = new SupplierDto(lieferant.getId(), lieferant.getName(), lieferant.getLink(), lieferant.getDeliveryTime(),warenIds);
                lieferantDtos.add(lieferantDto);
            }
            else{
                lieferantDtos.add(objectMapper.toDTO(lieferant));
            }
        }
        return lieferantDtos;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Transactional
    public List<SupplierDto> getAll() {
        var lieferants = loadAll();
        var lieferantsDto = lieferantToDto(lieferants);
        return lieferantsDto;
    }

    @POST
    @Path("/add")
    public Response add(SupplierDto supplierDto) {
        var lieferant = objectMapper.fromDto(supplierDto);

        im.add(lieferant);

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
