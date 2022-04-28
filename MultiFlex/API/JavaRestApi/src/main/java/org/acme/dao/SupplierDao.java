package org.acme.dao;

import org.acme.DTO.RegalDto;
import org.acme.DTO.SupplierDto;
import org.acme.mapper.SupplierMappingHelper;
import org.acme.repository.SupplierRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Dependent
@Path("/supplier")
public class SupplierDao {
    @Inject
    SupplierRepository repository;

    @Inject
    SupplierMappingHelper mappingHelper;

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Transactional
    public List<SupplierDto> getAll() {
        var suppliers = repository.loadAll();
        var supplierDtos = mappingHelper.toDto(suppliers);
        return supplierDtos;
    }
    @GET
    @Path("/get/{name}")
    @Transactional
    public List<SupplierDto> getByName(String name) {
        var entities = repository.findByName(name);
        var dtos = mappingHelper.toDto(entities);
        return dtos;
    }
    @GET
    @Path("/get/{id}")
    @Transactional
    public SupplierDto getById(Integer id) {
        var entities = repository.findById(id);
        var dtos = mappingHelper.toDto(entities);
        return dtos;
    }

    @POST
    @Path("/add")
    public Response add(SupplierDto supplierDto) {
        var supplier = mappingHelper.fromDto(supplierDto);

        repository.add(supplier);

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
        repository.delete(entity);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("/update")
    @Transactional
    public Response update(SupplierDto dto) {
        var entity = mappingHelper.fromDto(dto);
        //System.out.println(regalDto.getName());

        repository.update(entity);
        return Response.status(Response.Status.OK).build();
    }
}