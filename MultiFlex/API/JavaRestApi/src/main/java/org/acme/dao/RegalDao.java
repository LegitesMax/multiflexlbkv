package org.acme.dao;

import org.acme.DTO.RegalDto;
import org.acme.mapper.RegalHelper;
import org.acme.repository.RegalRepository;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;

@Dependent
@Path("/regal")
public class RegalDao {

    @Inject
    RegalRepository repository;

    @Inject
    RegalHelper mappingHelper;

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Transactional
    public List<RegalDto> getAll() {
        //var regals = loadAllRegal();
        var regals = repository.loadAll();
        var regalDtos = mappingHelper.toDto(regals);
        return regalDtos;
    }
    @GET
    @Path("/{name}")
    @Transactional
    public List<RegalDto> getOne(String name) {
        var regals = repository.loadByName(name);
        var regalDtos = mappingHelper.toDto(regals);
        return regalDtos;
    }

    @POST
    @Path("/add")
    public Response addRegal(RegalDto regalDto) {
        var regal = mappingHelper.fromDto(regalDto);
        System.out.println(regalDto.getName());
        repository.add(regal);
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
