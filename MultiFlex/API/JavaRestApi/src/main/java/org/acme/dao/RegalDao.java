package org.acme.dao;

import org.acme.DTO.RegalDto;
import org.acme.mapper.RegalMappingHelper;
import org.acme.repository.RegalRepository;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Dependent
@Path("/regal")
public class RegalDao {

    @Inject
    RegalRepository repository;

    @Inject
    RegalMappingHelper mappingHelper;

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
    @Path("/get/{name}")
    @Transactional
    public List<RegalDto> getByName(String name) {
        var entities = repository.findByName(name);
        var dtos = mappingHelper.toDto(entities);
        return dtos;
    }
    @GET
    @Path("/get/{id}")
    @Transactional
    public RegalDto getById(Integer id) {
        var entities = repository.findById(id);
        var dtos = mappingHelper.toDto(entities);
        return dtos;
    }

    @POST
    @Path("/add")
    public Response add(RegalDto regalDto) {
        var regal = mappingHelper.fromDto(regalDto);
        //System.out.println(regalDto.getName());
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

    @PUT
    @Path("/update")
    @Transactional
    public Response update(RegalDto dto) {
        var oldEntity = repository.findById(dto.getId());
        if(oldEntity == null) {
            throw new NotFoundException();
        }
        repository.remove(oldEntity);
        var model = mappingHelper.fromDto(dto);
        //System.out.println(regalDto.getName());

        repository.add(model);
        return Response.status(Response.Status.CREATED).build();
    }
}
