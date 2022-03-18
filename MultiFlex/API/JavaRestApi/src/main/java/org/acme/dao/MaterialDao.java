package org.acme.dao;

import org.acme.DTO.MaterialDto;
import org.acme.InsertManager;
import org.acme.mapper.ObjectMapper;
import org.acme.model.Material;
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
@Path("/material")
public class MaterialDao {
    @Inject
    EntityManager em;

    @Inject
    ObjectMapper objectMapper;

    @Transactional
    public void add(Material material){
        em.persist(material);}
    @Transactional
    public void remove(Material material){
        em.remove(material);
    }
    @Transactional
    public List<Material> loadAll() {
        return em.createQuery("select m from Material m", Material.class).getResultList();
    }
    @Transactional
    public Material findById(Integer id){
        return em.createQuery("select m from Material m where m.id = :id", Material.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
    public List<MaterialDto> materialToDto(List<Material> materialien){
        var materialDtos = new LinkedList<MaterialDto>();
        for(var material : materialien){
            if(material.getLieferanten().size() > 0) {
                var lieferantenSet = material.getLieferanten();
                List<Integer> lieferantenIds = new LinkedList<>();
                for (var material2 : lieferantenSet) {
                    lieferantenIds.add(material2.getId());
                }
                Collections.sort(lieferantenIds);
                MaterialDto materialDto = new MaterialDto(material.getId(), material.getName(), material.getDimension(),lieferantenIds);
                materialDtos.add(materialDto);
            }
        }
        return materialDtos;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Transactional
    public List<MaterialDto> getAll() {
        //var materialDto = new LinkedList<MaterialDto>();
        //var materials = loadAllRegal();
        var materials = loadAll();
        var materialDto = materialToDto(materials);
        return materialDto;
    }

    @POST
    @Path("/addmaterial")
    public Response add(MaterialDto materialDto) {
        var material = objectMapper.fromDto(materialDto);

        add(material);
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
