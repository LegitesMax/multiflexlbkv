package at.multiflex.mapper;

import at.multiflex.dto.CategoryDto;
import at.multiflex.dto.ColorDto;
import at.multiflex.model.Category;
import at.multiflex.model.Color;
import at.multiflex.repository.wares.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class CategoryMapper {
    @Inject
    ObjectMapper om;

    @Inject
    ProductRepository productRepository;

    public CategoryDto toDto(Category entity) {
        return om.toDto(entity);
    }
    public Category fromDto(CategoryDto dto) {
        var entity = om.fromDto(dto);

        if (dto.getProduct_ids() != null){
            entity.getProducts().forEach(x -> entity.getProducts().add(productRepository.findById(x.getId())));
        }

        return entity;
    }

    public List<CategoryDto> toDto(List<Category> entities) {
        var dtos = new LinkedList<CategoryDto>();
        entities.forEach(x -> dtos.add(om.toDto(x)));
        return dtos;
    }

    public List<Category> fromDto(List<CategoryDto> dtos) {
        var result = new LinkedList<Category>();
        dtos.forEach(x -> result.add(om.fromDto(x)));
        return result;
    }
}
