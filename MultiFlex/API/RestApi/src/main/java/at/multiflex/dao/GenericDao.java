package at.multiflex.dao;

import at.multiflex.dto.ColorDto;
import at.multiflex.dto.SizeDto;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.mapper.ObjectMapper;
import at.multiflex.model.Category;
import at.multiflex.model.Color;
import at.multiflex.model.Size;
import at.multiflex.model.Wares.Article;
import at.multiflex.model.Wares.Material;
import at.multiflex.model.Wares.Product;
import at.multiflex.repository.CategoryRepository;
import at.multiflex.repository.ColorRepository;
import at.multiflex.repository.SizeRepository;
import at.multiflex.repository.wares.ArticleRepository;
import at.multiflex.repository.wares.MaterialRepository;
import at.multiflex.repository.wares.ProductRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


public class GenericDao {

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

    protected Class<?> type;

    //<editor-fold desc="Get">
    /**
     * This gets all entities with this type from the Database and returns a list with them
     * @return a list with all ProductDtos
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Object> getAll() throws DaoException {
        //System.out.println(type.getName());
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
        switch (type.getName()){
            case "at.multiflex.model.Wares.Product":
                System.out.println(Article.class.getName());
                System.out.println(Article.class.getName());
                System.out.println(Material.class.getName());
                System.out.println(Product.class.getName());
                System.out.println(Category.class.getName());
                System.out.println(Color.class.getName());
                System.out.println(Size.class.getName());
                System.out.println(type.getName());
                System.out.println(type);
        }

        return MappingHelper.entityDtoTransformation(entities);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/{name}")
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
    public <T> Response add(T dto) throws DaoException {
        if (Article.class.equals(type)) {
            var entity = (Article) MappingHelper.entityDtoTransformation(dto);
            productRepository.add( entity);
        } else if (Material.class.equals(type)){
            var entity = (Material) MappingHelper.entityDtoTransformation(dto);
            productRepository.add(entity);
        } else if (Product.class.equals(type)){
            var entity =  MappingHelper.entityDtoTransformation(dto);
            var res = convertInstanceOfObject(entity, Product.class);
            productRepository.add(entity);
        } else if (Category.class.equals(type)){
            var entity = (Category) MappingHelper.entityDtoTransformation(dto);
            productRepository.add(entity);
        } else if (Color.class.equals(type)){
            var entity = (Color) MappingHelper.entityDtoTransformation(dto);
            productRepository.add(entity);
        } else if (Size.class.equals(type)){
            var entity = MappingHelper.entityDtoTransformation(dto);

            productRepository.add((Size) entity);
        } else{
            throw new DaoException("Entity type does exist");
        }
        return Response.status(Response.Status.CREATED).build();
    }
    public static <T> T convertInstanceOfObject(Object o, Class<T> clazz) {
        try {
            return clazz.cast(o);
        } catch(ClassCastException e) {
            return null;
        }
    }
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
        //var x = convertInstanceOfObject(entity, type);
        productRepository.delete(entity);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    @Path("/update")
    public Response update(ColorDto dto) {
        var entity = ObjectMapper.MAPPER.fromDto(dto);
        repository.update(entity);
        return Response.status(Response.Status.OK).build();
    }
}
