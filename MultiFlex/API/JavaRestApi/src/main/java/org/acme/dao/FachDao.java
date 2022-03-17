package org.acme.dao;

import org.acme.DTO.FachDto;
import org.acme.DTO.MaterialDto;
import org.acme.InsertManager;
import org.acme.mapper.ObjectMapper;
import org.acme.model.Fach;
import org.acme.model.Material;
import org.acme.model.Regal;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Dependent
@Path("/fach")
public class FachDao {
    @Inject
    EntityManager entityManager;

    @Inject
    ObjectMapper objectMapper;

    InsertManager insertManager;

    //@Inject
    //InsertManager insertManager;

    public List<Fach> loadAllFaecher() {
        return entityManager.createQuery("select f from Fach f", Fach.class).getResultList();
    }

    public Fach loadOneFach(Integer id){
        return entityManager.createQuery("select f from Fach f where f.id = :id", Fach.class).setParameter("id", id).getSingleResult();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<FachDto> getAll() {
        var fachDtos = new LinkedList<FachDto>();
        var faecher = entityManager.createQuery("select f from Fach f", Fach.class).getResultList();
        for(var fach : faecher){
            FachDto fachDto = new FachDto(fach.getId(), fach.getPosition(), fach.getMaxbestand(), fach.getWare().getId(), fach.getRegal().getId());
            fachDtos.add(fachDto);
        }
        return fachDtos;
    }

    @POST
    @Path("/addfach")
    public Response add(FachDto fachDto) {
        var fach = objectMapper.fromDto(fachDto);

        insertManager.add(fach);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        var entity = loadOneFach(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        insertManager.remove(entity);
    }
}
