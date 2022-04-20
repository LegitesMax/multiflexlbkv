package org.acme.dao;

import org.acme.DTO.RegalDto;
import org.acme.DTO.WareDto;
import org.acme.mapper.WareMappingHelper;
import org.acme.repository.WareRepository;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Dependent
@Path("/ware")
public class WareDao {
    @Inject
    WareRepository repository;

    @Inject
    WareMappingHelper mappingHelper;

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Transactional
    public List<WareDto> getAll() {
        //var regale = loadAllRegal();
        var wares = repository.loadAll();
        var wareDtos = mappingHelper.toDto(wares);
        return wareDtos;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("material")
    @Transactional
    public List<WareDto> getAllMaterials() {
        //var regale = loadAllRegal();
        var wares = repository.loadAllMaterials();
        //var wareDtos = regalToDto(wares);
        //return wareDtos;
        return mappingHelper.toDto(wares);
        //return loadAllMaterials();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("product")
    @Transactional
    public List<WareDto> getAllProducts() {
        //var regale = loadAllRegal();
        var wares = repository.loadAllProduct();
        var wareDtos = mappingHelper.toDto(wares);
        return wareDtos;
    }
    @GET
    @Path("/get/{name}")
    @Transactional
    public List<WareDto> getByName(String name) {
        var entities = repository.loadByName(name);
        var dtos = mappingHelper.toDto(entities);
        return dtos;
    }
    @GET
    @Path("/get/{id}")
    @Transactional
    public WareDto getById(Integer id) {
        var entities = repository.findById(id);
        var dtos = mappingHelper.toDto(entities);
        return dtos;
    }

    @Transactional
    @POST
    @Path("/add")
    public Response add(WareDto wareDto) {
        var ware = mappingHelper.fromDto(wareDto);
        System.out.println(wareDto.getName());
        repository.add(ware);
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
