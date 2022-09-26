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

/**
 * This class includes all json requests for the Article class
 */
@Dependent
@Path("/Article")
public class ArticleDao {
    @Inject
    ArticleRepository repository;

    //<editor-fold desc="Get">
    /**
     * This gets all entities with this type from the Database and returns a list with them
     * @return a list with all ArticleDtos
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<ArticleDto> getAll() {
        var entities = repository.loadAll();
        return toDto(entities);
    }
    /**
     * This gets specific entities from this type from the Database and returns a list with them
     * @param name Article name which should be searched
     * @return All entities with this name
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/{name}")
    public List<ArticleDto> getByName(String name) {
        var entities = repository.findByName(name);
        return toDto(entities);
    }
    /**
     * gets an entity from this class by its id
     * @param id the id of the Article to return
     * @return The Article with the id of the input param
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/{id}")
    public ArticleDto getById(Integer id) {
        var entity = repository.findById(id);
        return ObjectMapper.MAPPER.toDto(entity);
    }
    //</editor-fold>
    //<editor-fold desc="Post">
    /**
     * transforms a given dto to an entity and adds it into the database
     * @param dto A dto to insert into the database
     * @return The JSON Response code
     */
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
    /**
     * Deletes an Article entity by that entities id
     * @param id The id of an entity to delete
     * @return The JSON Response code
     */
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
    /**
     * Transforms a dto into an Article and updates it
     * @param dto The dto of the entity
     * @return The JSON Response code
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/update")
    public Response update(ArticleDto dto) {
        var entity = ObjectMapper.MAPPER.fromDto(dto);
        repository.update(entity);
        return Response.status(Response.Status.OK).build();
    }
    //</editor-fold>
    /**
     * Method to transform a list of Article entities to a dto
     * @param entities list of all Article entities to transform
     * @return the dtos of all given entities
     */
    public List<ArticleDto> toDto(List<Article> entities) {
        var dtos = new ArrayList<ArticleDto>();
        entities.forEach(x -> dtos.add(ObjectMapper.MAPPER.toDto(x)));
        return dtos;
    }
}
