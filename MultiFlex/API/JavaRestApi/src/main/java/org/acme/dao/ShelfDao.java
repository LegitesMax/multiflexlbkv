package org.acme.dao;

import org.acme.DTO.ShelfDto;
import org.acme.repository.CRUDOperations;
import org.acme.mapper.ObjectMapper;
import org.acme.repository.ShelfRepository;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Dependent
@Path("/shelf")
public class ShelfDao {
    @Inject
    ShelfRepository repository;

    @Inject
    ObjectMapper objectMapper;

    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<ShelfDto> getAll() {
        var fachDtos = new LinkedList<ShelfDto>();
        //var faecher = entityManager.createQuery("select f from Shelf f", Shelf.class).getResultList();
        var faecher = repository.loadAll();
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

        repository.add(fach);
        return Response.status(Response.Status.CREATED).build();
    }
    @Transactional
    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Integer id) {
        var entity = repository.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        repository.remove(entity);
    }
}
