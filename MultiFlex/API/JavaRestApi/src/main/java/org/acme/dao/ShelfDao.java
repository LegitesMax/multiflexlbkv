package org.acme.dao;

import org.acme.DTO.RegalDto;
import org.acme.DTO.ShelfDto;
import org.acme.DTO.SupplierDto;
import org.acme.mapper.ShelfMappingHelper;
import org.acme.repository.ShelfRepository;

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
    @GET
    @Path("/get/{id}")
    @Transactional
    public ShelfDto getById(Integer id) {
        var entities = repository.findById(id);
        var dtos = mappingHelper.toDto(entities);
        return dtos;
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
    public Response delete(@PathParam("id") Integer id) {
        var entity = repository.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        repository.remove(entity);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("/update")
    @Transactional
    public Response update(ShelfDto dto) {
        var entity = mappingHelper.fromDto(dto);
        //System.out.println(regalDto.getName());

        repository.update(entity);
        return Response.status(Response.Status.OK).build();
    }
}