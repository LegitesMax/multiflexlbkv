package at.multiflex.dao.wares;

import at.multiflex.dto.wares.ArticleDto;
import at.multiflex.mapper.ObjectMapper;
import at.multiflex.model.Wares.Article;
import at.multiflex.repository.wares.ArticleRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Dependent
@Path("/Article")
public class ArticleDao {
    @Inject
    ArticleRepository repository;

    //<editor-fold desc="Get">
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<ArticleDto> getAll() {
        var entities = repository.loadAll();
        return toDto(entities);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/{name}")
    public List<ArticleDto> getByName(String name) {
        var entities = repository.findByName(name);
        return toDto(entities);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/{id}")
    public ArticleDto getById(Integer id) {
        var entity = repository.findById(id);
        return ObjectMapper.MAPPER.toDto(entity);
    }
    //</editor-fold>
    //<editor-fold desc="Post">
    @POST
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/add")
    public Response add(ArticleDto dto) {
        var entity = ObjectMapper.MAPPER.fromDto(dto);
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
    public Response update(ArticleDto dto) {
        var entity = ObjectMapper.MAPPER.fromDto(dto);
        repository.update(entity);
        return Response.status(Response.Status.OK).build();
    }
    //</editor-fold>
    public List<ArticleDto> toDto(List<Article> entities) {
        var dtos = new ArrayList<ArticleDto>();
        entities.forEach(x -> dtos.add(ObjectMapper.MAPPER.toDto(x)));
        return dtos;
    }
}
