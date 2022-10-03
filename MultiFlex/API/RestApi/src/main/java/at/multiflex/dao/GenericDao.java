package at.multiflex.dao;

import at.multiflex.dto.ColorDto;
import at.multiflex.dto.SizeDto;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.model.Category;
import at.multiflex.model.Color;
import at.multiflex.model.Size;
import at.multiflex.model.Wares.Article;
import at.multiflex.model.Wares.Material;
import at.multiflex.model.Wares.Product;
import at.multiflex.repository.*;
import at.multiflex.repository.wares.ArticleRepository;
import at.multiflex.repository.wares.MaterialRepository;
import at.multiflex.repository.wares.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * A generic class for all dao classes
 */
public class GenericDao{

    @Inject
    ArticleRepository articleRepository;
    @Inject
    MaterialRepository materialRepository;
    @Inject
    ProductRepository productRepository;
    @Inject
    CategoryRepository categoryRepository;
    @Inject
    ColorRepository colorRepository;
    @Inject
    SizeRepository sizeRepository;
    @Inject
    CRUDOperations crudOperations;
    //@Inject
    //Repository repository;

    protected Class<?> type;

    /**
     * This gets all entities with this type from the Database and returns a list with them
     * @return a list with all Dtos
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Object> getAll() throws DaoException {
        List<?> entities;
        if (Article.class.equals(type)) {
            entities = articleRepository.loadAll();
        } else if (Material.class.equals(type)){
            entities = materialRepository.loadAll();
        } else if (Product.class.equals(type)){
            entities = productRepository.loadAll();
        } else if (Category.class.equals(type)){
            entities = categoryRepository.loadAll();
        } else if (Color.class.equals(type)){
            entities = colorRepository.loadAll();
        } else if (Size.class.equals(type)){
            entities = sizeRepository.loadAll();
        } else{
            throw new DaoException("Entity does not exist");
        }

        return MappingHelper.entityDtoTransformation(entities);
    }
    /**
     * This gets specific entities from this type from the Database and returns a list with them
     * @param name name which should be searched
     * @return All entities with this name
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/name/{name}")
    public List<Object> getByName(String name) throws DaoException {
        List<? extends Article> entities;
        if (Article.class.equals(type)) {
            entities = articleRepository.findByName(name);
        } else if (Material.class.equals(type)){
            entities = materialRepository.findByName(name);
        } else if (Product.class.equals(type)){
            entities = productRepository.findByName(name);
        } else{
            throw new DaoException("Entity does not have a name, or no available DB request");
        }
        return MappingHelper.entityDtoTransformation(entities);
    }
    /**
     * gets an entity from this class by its id
     * @param id the id of the class to return
     * @return The class with the id of the input param
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/{id}")
    public Object getById(Integer id) throws DaoException {
        Object entity;
        if (Article.class.equals(type)) {
            entity = articleRepository.findById(id);
        } else if (Material.class.equals(type)){
            entity = materialRepository.findById(id);
        } else if (Product.class.equals(type)){
            entity = productRepository.findById(id);
        } else if (Category.class.equals(type)){
            entity = categoryRepository.findById(id);
        } else if (Color.class.equals(type)){
            entity = colorRepository.findById(id);
        } else if (Size.class.equals(type)){
            entity = sizeRepository.findById(id);
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
    @Path("/add")
    public Response add(Object input) throws DaoException {
        ObjectMapper mapper = new ObjectMapper();
        Object entity;
        if (Article.class.equals(type)) {
            var dto = mapper.convertValue(input, Article.class);
            entity = MappingHelper.entityDtoTransformation(dto);
        } else if (Material.class.equals(type)){
            var dto = mapper.convertValue(input, Material.class);
            entity = MappingHelper.entityDtoTransformation(dto);
        } else if (Product.class.equals(type)){
            var dto = mapper.convertValue(input, Product.class);
            entity = MappingHelper.entityDtoTransformation(dto);
        } else if (Category.class.equals(type)){
            var dto = mapper.convertValue(input, Category.class);
            entity = MappingHelper.entityDtoTransformation(dto);
        } else if (Color.class.equals(type)){
            var dto = mapper.convertValue(input, Color.class);
            entity = MappingHelper.entityDtoTransformation(dto);
        } else if (Size.class.equals(type)){
            var dto = mapper.convertValue(input, SizeDto.class);
            entity = MappingHelper.entityDtoTransformation(dto);
        } else{
            throw new DaoException("Entity type does exist");
        }
        crudOperations.add(entity);
        return Response.status(Response.Status.CREATED).build();
    }
    /**
     * Deletes a entity by that entities id
     * @param id The id of an entity to delete
     * @return The JSON Response code
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Integer id) throws DaoException {
        Object entity;
        if (Article.class.equals(type)) {
            entity = articleRepository.findById(id);
        } else if (Material.class.equals(type)){
            entity = materialRepository.findById(id);
        } else if (Product.class.equals(type)){
            entity = productRepository.findById(id);
        } else if (Category.class.equals(type)){
            entity = categoryRepository.findById(id);
        } else if (Color.class.equals(type)){
            entity = colorRepository.findById(id);
        } else if (Size.class.equals(type)){
            entity = sizeRepository.findById(id);
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
     * @param input The dto of the entity
     * @return The JSON Response code
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/update")
    public Response update(Object input) throws DaoException {
        ObjectMapper mapper = new ObjectMapper();
        Object entity;
        if (Article.class.equals(type)) {
            var dto = mapper.convertValue(input, Article.class);
            entity = MappingHelper.entityDtoTransformation(dto);
        } else if (Material.class.equals(type)){
            var dto = mapper.convertValue(input, Material.class);
            entity = MappingHelper.entityDtoTransformation(dto);
        } else if (Product.class.equals(type)){
            var dto = mapper.convertValue(input, Product.class);
            entity = MappingHelper.entityDtoTransformation(dto);
        } else if (Category.class.equals(type)){
            var dto = mapper.convertValue(input, Category.class);
            entity = MappingHelper.entityDtoTransformation(dto);
        } else if (Color.class.equals(type)){
            var dto = mapper.convertValue(input, Color.class);
            entity = MappingHelper.entityDtoTransformation(dto);
        } else if (Size.class.equals(type)){
            var dto = mapper.convertValue(input, SizeDto.class);
            entity = MappingHelper.entityDtoTransformation(dto);
        } else{
            throw new DaoException("Entity type does exist");
        }
        crudOperations.update(entity);
        return Response.status(Response.Status.OK).build();
    }
}
