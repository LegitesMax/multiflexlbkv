package org.acme.dao;

import org.acme.DTO.FachDto;
import org.acme.DTO.MaterialDto;
import org.acme.mapper.ObjectMapper;
import org.acme.model.Fach;
import org.acme.model.Material;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

public class FachDao {
    @Inject
    EntityManager entityManager;

    @Inject
    ObjectMapper objectMapper;

    public void add(Fach f) {
        entityManager.persist(f);
    }

    public List<Fach> loadAllRegal() {
        return entityManager.createQuery("select f from Fach f", Fach.class).getResultList();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<FachDto> getAll() {
        var fachDto = new LinkedList<FachDto>();
        var facher = loadAllRegal();
        for (var fach : facher){
            fachDto.add(objectMapper.toDTO(fach));
        }
        return fachDto;
    }

    @POST
    @Path("/addfach")
    public Response add(FachDto fachDto) {
        var fach = objectMapper.fromDto(fachDto);

        add(fach);
        return Response.status(Response.Status.CREATED).build();
    }
}
