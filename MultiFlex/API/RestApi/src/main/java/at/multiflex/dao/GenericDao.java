package at.multiflex.dao;

import at.multiflex.mapper.MappingHelper;
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
import java.util.List;

@Dependent
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
}
