package org.acme.dao;

import org.acme.DTO.TypeDto;
import org.acme.mapper.TypeHelper;
import org.acme.repository.TypeRepository;
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
@Path("/type")
public class TypeDao {
    @Inject
    TypeRepository repository;

    @Inject
    TypeHelper mappingHelper;

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Transactional
    public List<TypeDto> getAll() {
        //var regale = loadAllRegal();
        var typDtos = new LinkedList<TypeDto>();
        var typen = repository.loadAll();
        for (var typ: typen) {
            typDtos.add(mappingHelper.toDto(typ));
        }
        return typDtos;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Transactional
    @Path("/material")
    public List<TypeDto> getAllMaterial() {
        //var regale = loadAllRegal();
        var typDtos = new LinkedList<TypeDto>();
        var typen = repository.loadAllMaterial();
        for (var typ: typen) {
            typDtos.add(mappingHelper.toDto(typ));
        }
        return typDtos;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/product")
    @Transactional
    public List<TypeDto> getAllProduct() {
        //var regale = loadAllRegal();
        var typDtos = new LinkedList<TypeDto>();
        var typen = repository.loadAllProduct();
        for (var typ: typen) {
            typDtos.add(mappingHelper.toDto(typ));
        }
        return typDtos;
    }

    @POST
    @Path("/add")
    public Response addRegal(TypeDto type) {
        var typ = mappingHelper.fromDto(type);
        //System.out.println(type.getName());
        repository.add(typ);
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
