package org.acme.dao;

import org.acme.DTO.ShelfDto;
import org.acme.mapper.ShelfMappingHelper;
import org.acme.repository.ShelfRepository;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Dependent
@Path("/shelf")
public class ShelfDao {
    @Inject
    ShelfRepository repository;

    @Inject
    ShelfMappingHelper mappingHelper;

    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<ShelfDto> getAll() {
        //var shelves = entityManager.createQuery("select f from Shelf f", Shelf.class).getResultList();
        var shelves = repository.loadAll();
        var shelfDtos = mappingHelper.toDto(shelves);
        return shelfDtos;
    }

    @POST
    @Path("/add")
    public Response add(ShelfDto fachDto) {
        var shelf = mappingHelper.fromDto(fachDto);
        repository.add(shelf);
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
