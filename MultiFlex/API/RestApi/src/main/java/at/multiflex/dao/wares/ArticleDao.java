package at.multiflex.dao.wares;

import at.multiflex.Logic.CRUDLogic;
import at.multiflex.dao.DaoException;
import at.multiflex.dto.wares.ArticleDto;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.mapper.ObjectMapper;
import at.multiflex.model.Wares.Article;
import at.multiflex.repository.CRUDOperations;
import at.multiflex.repository.wares.ArticleRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * This class includes all json requests for the Article class
 */
@Path("/Article")
public class ArticleDao {
    /**
     * A Constructor that tells the superclass which entity class to use
     */
    public ArticleDao() {
        type = Article.class;
    }
    /**
     * type of the class
     */
    protected Class<?> type;
    /**
     * all create update delete operations
     */
    @Inject
    protected CRUDOperations crudOperations;
    @Inject
    CRUDLogic crudLogic;

    /**
     * repository for the article class
     */
    @Inject
    protected ArticleRepository articleRepository;
    /**
     * This gets all entities with this type from the Database and returns a list with them
     * @return a list with all Dtos
     * @throws DaoException throws a DaoException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Object> getAll() throws DaoException {
        List<Article> entities;
        if (Article.class.equals(type)) {
            entities = articleRepository.loadAll();
        } else{
            throw new DaoException("Entity does not exist");
        }

        return MappingHelper.entityDtoTransformation(entities);
    }
    /**
     * This gets specific entities from this type from the Database and returns a list with them
     * @param name name which should be searched
     * @return All entities with this name
     * @throws DaoException throws a DaoException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/name/{name}")
    public List<Object> getByName(String name) throws DaoException {
        List<Article> entities;
        if (Article.class.equals(type)) {
            entities = articleRepository.findByName(name);
        } else{
            throw new DaoException("Entity does not have a name, or no available DB request");
        }
        return MappingHelper.entityDtoTransformation(entities);
    }
    /**
     * gets an entity from this class by its id
     * @param id the id of the class to return
     * @return The class with the id of the input param
     * @throws DaoException throws a DaoException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/{id}")
    public Object getById(Integer id) throws DaoException {
        Article entity;
        if (Article.class.equals(type)) {
            entity = articleRepository.findById(id);
        } else{
            throw new DaoException("Entity does not exist");
        }
        return MappingHelper.entityDtoTransformation(entity);
    }
    /**
     * transforms a given dto to an entity and adds it into the database
     * @param input A dto to insert into the database
     * @return The JSON Response code
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Consumes
    @Path("/add")
    public Response add(ArticleDto input) {
        var entity = (Article) MappingHelper.entityDtoTransformation(input);

        entity = crudLogic.setEmptyFields(entity);

        crudOperations.add(entity);

        return Response.status(Response.Status.CREATED).build();
    }
    /**
     * Deletes a entity by that entities id
     * @param id The id of an entity to delete
     * @return The JSON Response code
     * @throws DaoException throws a DaoException
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Integer id) throws DaoException {
        Object entity;
        if (Article.class.equals(type)) {
            entity = articleRepository.findById(id);
        } else{
            throw new DaoException("Entity does not exist");
        }
        if(entity == null) {
            throw new NotFoundException();
        }

        crudOperations.delete(entity);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    /**
     * Transforms a dto into a entity and updates it
     * @param dto The dto of the entity
     * @return The JSON Response code
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/update")
    public Response update(ArticleDto dto) {
        var entity = articleRepository.findByName(dto.getName()).get(0);
        //var entity = ObjectMapper.MAPPER.fromDto(dto);
        var entity2 = ObjectMapper.MAPPER.fromDto(dto);
        //if (entity2.getName() != null){
            entity.setName(entity2.getName());
        //}else if (entity2.getMinValue() != null) {
            entity.setMinValue(entity2.getMinValue());
        //}else if (entity2.getValue() != null) {
            entity.setValue(entity2.getValue());
        /*}else if (entity2.getCategory() != null){
            entity.setCategory(entity2.getCategory());
        }else if (entity2.getColor() != null) {
            entity.setColor(entity2.getColor());
        }else if (entity2.getSize() != null) {
            entity.setSize(entity2.getSize());
        }
        */

        crudOperations.update(entity);
        return Response.status(Response.Status.OK).build();
    }
}
