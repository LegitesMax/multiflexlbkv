package at.multiflex.dao;

import at.multiflex.dto.ProductionFormulaDto;
import at.multiflex.mapper.ProductionFormulaMapper;
import at.multiflex.repository.ProductionFormulaRepostitory;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Dependent
@Path("/ProductionFormula")
public class ProductionFormulaDao {
    @Inject
    ProductionFormulaRepostitory repository;

    @Inject
    ProductionFormulaMapper mapper;

    //<editor-fold desc="Get">
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<ProductionFormulaDto> getAll() {
        var entities = repository.loadAll();
        return mapper.toDto(entities);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/get/{id}")
    public ProductionFormulaDto getById(Integer id) {
        var entity = repository.findById(id);
        return mapper.toDto(entity);
    }
    //</editor-fold>
    //<editor-fold desc="Post">
    @POST
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/add")
    public Response add(ProductionFormulaDto dto) {
        var entity = mapper.fromDto(dto);
        repository.add(entity);
        return Response.status(Response.Status.CREATED).build();
    }
    //</editor-fold>
    //<editor-fold desc="Delete">
    @DELETE
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Integer id) {
        var entity = repository.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        repository.delete(entity);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    //</editor-fold>
    //<editor-fold desc="Put">
    @PUT
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/update")
    public Response update(ProductionFormulaDto dto) {
        var entity = mapper.fromDto(dto);
        repository.update(entity);
        return Response.status(Response.Status.OK).build();
    }
    //</editor-fold>
}
