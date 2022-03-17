package org.acme.dao;

import org.acme.DTO.LieferantDto;
import org.acme.DTO.MaterialDto;
import org.acme.DTO.RegalDto;
import org.acme.mapper.LieferantMapper;
import org.acme.mapper.ObjectMapper;
import org.acme.model.Lieferant;
import org.acme.model.Material;
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
@Path("/material")
public class MaterialDao {
    @Inject
    EntityManager entityManager;

    //@Inject
    //RegalDao regalDao;

    @Inject
    ObjectMapper objectMapper;

    public void add(Material m) {
        entityManager.persist(m);
    }

    public List<Material> loadAllRegal() {
        return entityManager.createQuery("select m from Material m", Material.class).getResultList();
    }

    public Material loadOneRegal(String name){
        return entityManager.createQuery("select m from Material m where m.name = :name", Material.class).setParameter("name", name).getSingleResult();
    }
    public List<Material> loadSpecificRegal(@PathParam String name){
        return entityManager.createQuery("select m from Material m where m.name like lower(concat('%', concat(:name, '%')))", Material.class).setParameter("name", name).getResultList();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<MaterialDto> getAll() {
        var materialDto = new LinkedList<MaterialDto>();
        var materials = loadAllRegal();
        for (var material : materials){
            materialDto.add(objectMapper.toDTO(material));
        }
        return materialDto;
    }

    @POST
    @Path("/addmaterial")
    public Response add(MaterialDto materialDto) {
        var material = objectMapper.fromDto(materialDto);

        add(material);
        return Response.status(Response.Status.CREATED).build();
    }

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
}
