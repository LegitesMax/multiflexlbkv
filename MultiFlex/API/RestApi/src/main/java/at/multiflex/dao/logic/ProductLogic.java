package at.multiflex.dao.logic;

import at.multiflex.dto.traffic.CategoryColorProducts;
import at.multiflex.dto.traffic.CategoryProducts;
import at.multiflex.dto.traffic.ColorProducts;
import at.multiflex.dto.traffic.ProductsWithColor;
import at.multiflex.dto.wares.ProductDto;
import at.multiflex.mapper.CategoryMapper;
import at.multiflex.mapper.ColorMapper;
import at.multiflex.mapper.wares.ProductMapper;
import at.multiflex.model.Color;
import at.multiflex.model.Wares.Product;
import at.multiflex.repository.CategoryRepository;
import at.multiflex.repository.ColorRepository;
import at.multiflex.repository.wares.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductLogic {
    //<editor-fold desc="Inject">
    @Inject
    ProductRepository productRepository;
    @Inject
    CategoryRepository categoryRepository;
    @Inject
    ColorRepository colorRepository;
    @Inject
    ProductMapper productMapper;
    @Inject
    CategoryMapper categoryMapper;
    @Inject
    ColorMapper colorMapper;
    //</editor-fold>
    //<editor-fold desc="CategoryProduct">
    public CategoryProducts getProductsByByCategory(String categoryName){

        var products = productRepository.findByCategory(categoryName);

        var category = categoryRepository.findByName(categoryName);

        return new CategoryProducts( categoryMapper.toDto(category), productMapper.toDto(products));
    }
    public CategoryProducts getProductsByByCategoryAcronym(String acronym){

        var products = productRepository.findByCategoryAcronym(acronym);

        var category = categoryRepository.findByAcronym(acronym);

        return new CategoryProducts( categoryMapper.toDto(category), productMapper.toDto(products));
    }
    public List<CategoryProducts> getAllProductsByByCategory(){

        var category = categoryRepository.loadAll();
        var cp = new ArrayList<CategoryProducts>();
        category.forEach(x -> {
            var products = productRepository.findByCategory(x.getName());
            cp.add(new CategoryProducts(categoryMapper.toDto(x), productMapper.toDto(products)));
        });

        return cp;
    }
    //</editor-fold>
    //<editor-fold desc="ColorProduct">
    public ColorProducts getProductsByByColor(String categoryName){

        var products = productRepository.findByCategory(categoryName);

        var entity = colorRepository.findByName(categoryName);

        return new ColorProducts( colorMapper.toDto(entity), productMapper.toDto(products));
    }
    public ColorProducts getProductsByByColorAcronym(String id){

        var products = productRepository.findByCategoryAcronym(id);

        var entities = colorRepository.findByColorId(id);

        return new ColorProducts( colorMapper.toDto(entities), productMapper.toDto(products));
    }
    public List<ColorProducts> getAllProductsByByColor(){

        var entities = colorRepository.loadAll();
        var cp = new ArrayList<ColorProducts>();
        entities.forEach(x -> {
            var products = productRepository.findByColor(x.getName());
            cp.add(new ColorProducts(colorMapper.toDto(x), productMapper.toDto(products)));
        });

        return cp;
    }

    //public List<CategoryColorProducts> getAllProductsByCategoryAndByColor(){
    //    var products = productRepository.loadAll();
    //    var color = new ArrayList<Color>();
    //    var category = new ArrayList<Color>();
//
    //    products.forEach(x -> {
    //
    //    });
//
    //    var entities = colorRepository.loadAll();
    //    var cp = new ArrayList<CategoryColorProducts>();
    //    entities.forEach(x -> {
    //        var products = productRepository.findByColor(x.getName());
    //        cp.add(new ColorProducts(colorMapper.toDto(x), productMapper.toDto(products)));
    //    });
//
//
    //    return cp;
    //}
    public List<CategoryColorProducts> getAllProductsByCategoryAndByColor(){

        var category = categoryRepository.loadAll();
        var cp = new ArrayList<CategoryColorProducts>();
        category.forEach(x -> {
            var products = productRepository.findByCategory(x.getName());
            var productsWithColor = new ArrayList<ProductsWithColor>();
            products.forEach(y -> {
                var color = y.getColor();
                var productWithColor = new ProductsWithColor();

                productWithColor.setName(y.getName());
                productWithColor.setId(y.getId());
                productWithColor.setValue(y.getValue());
                productWithColor.setMinValue(y.getMinValue());
                productWithColor.setMaterial_ids(y.getMaterial_ids());

                productWithColor.setColorCode(color.getColorCode());
                productWithColor.setColorName(color.getName());

                productsWithColor.add(productWithColor);
            });

            cp.add(new CategoryColorProducts(categoryMapper.toDto(x), productsWithColor));
        });

        return cp;
    }
    //</editor-fold>

}
