package at.multiflex.dao;

import at.multiflex.dto.wares.ProductDto;
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
import org.jboss.resteasy.reactive.RestPath;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class GenericDao<T> {

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

    protected Class<T> type;

    //<editor-fold desc="Get">
    /**
     * This gets all entities with this type from the Database and returns a list with them
     * @return a list with all ProductDtos
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Object> getAll() {
        //System.out.println(type.getName());
        List entities = new ArrayList();
        if (Article.class.getName().equals(type.getName())) {
            entities = articleRepository.loadAll();
        } else if (Material.class.getName().equals(type.getName())){
            entities = materialRepository.loadAll();
        } else if (Product.class.getName().equals(type.getName())){
            entities = productRepository.loadAll();
        } else if (Category.class.getName().equals(type.getName())){
            entities = categoryRepository.loadAll();
        } else if (Color.class.getName().equals(type.getName())){
            entities = colorRepository.loadAll();
        } else if (Size.class.getName().equals(type.getName())){
            entities = sizeRepository.loadAll();
        } else{
            try {
                throw new Exception("Entity does not exist");
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        }
        return MappingHelper.entityDtoTransformation(entities);
    }
}
