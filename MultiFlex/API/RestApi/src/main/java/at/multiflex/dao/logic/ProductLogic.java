package at.multiflex.dao.logic;

import at.multiflex.dto.traffic.CategoryProducts;
import at.multiflex.dto.wares.ProductDto;
import at.multiflex.mapper.CategoryMapper;
import at.multiflex.mapper.wares.ProductMapper;
import at.multiflex.model.Wares.Product;
import at.multiflex.repository.CategoryRepository;
import at.multiflex.repository.wares.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductLogic {
    @Inject
    ProductRepository productRepository;
    @Inject
    CategoryRepository categoryRepository;
    @Inject
    ProductMapper productMapper;
    @Inject
    CategoryMapper categoryMapper;

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


}
