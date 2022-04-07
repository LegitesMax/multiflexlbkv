package org.acme.dao;

import org.acme.DTO.RegalDto;
import org.acme.repository.CRUDOperations;
import org.acme.mapper.ObjectMapper;
import org.acme.model.Regal;
import org.acme.repository.RegalRepository;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Dependent
@Path("/regal")
public class RegalDao {

    @Inject
    RegalRepository repository;

    @Inject
    ObjectMapper objectMapper;

    @Transactional
    public List<RegalDto> regalToDto(List<Regal> regale){
        var regalDtos = new LinkedList<RegalDto>();
        for(var regal : regale){
            if(regal.getShelfs().size() > 0) {
                var fachSet = regal.getShelfs();
                List<Integer> fachIds = new LinkedList<>();
                for (var fach : fachSet) {
                    fachIds.add(fach.getId());
                }
                Collections.sort(fachIds);
                RegalDto regalDto = new RegalDto(regal.getId(), regal.getName(), regal.getMaxAmountShelfs(), fachIds);
                regalDtos.add(regalDto);
            }
        }
        return regalDtos;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Transactional
    public List<RegalDto> getAll() {
        //var regale = loadAllRegal();
        var regale = repository.loadAll();
        var regalDtos = regalToDto(regale);
        return regalDtos;
    }
    @GET
    @Path("/{name}")
    @Transactional
    public List<RegalDto> getOne(String name) {
        var regale = repository.loadByName(name);
        var regalDtos = regalToDto(regale);
        return regalDtos;
    }

    @POST
    @Path("/add")
    public Response addRegal(RegalDto regalDto) {
        var regal = objectMapper.fromDto(regalDto);
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
