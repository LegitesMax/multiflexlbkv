package at.multiflex.mapper.wares;

import at.multiflex.dto.wares.ProductDto;
import at.multiflex.mapper.ObjectMapper;
import at.multiflex.model.Wares.Product;
import at.multiflex.repository.CategoryRepository;
import at.multiflex.repository.ColorRepository;
import at.multiflex.repository.SizeRepository;
import at.multiflex.repository.wares.MaterialRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class ProductMapper {
    @Inject
    ObjectMapper om;

    @Inject
    MaterialRepository materialRepository;
    @Inject
    ColorRepository colorRepository;
    @Inject
    CategoryRepository categoryRepository;
    @Inject
    SizeRepository sizeRepository;
    public ProductDto toDto(Product entity) {
        return om.toDto(entity);
    }
    public Product fromDto(ProductDto dto) {
        var entity = om.fromDto(dto);

        if (dto.getMaterial_ids() != null){
            entity.getMaterial_ids().forEach(x -> entity.getMaterials().add(materialRepository.findById(x)));
        }
        if (dto.getColor_id() != null){
            entity.setColor(colorRepository.findById(dto.getColor_id()));
        }
        if (dto.getCategory_id() != null){
            entity.setCategory(categoryRepository.findById(dto.getCategory_id()));
        }
        if (dto.getSize_id() != null){
            entity.setSize(sizeRepository.findById(dto.getSize_id()));
        }

        return entity;
    }

    public List<ProductDto> toDto(List<Product> entities) {
        var dtos = new LinkedList<ProductDto>();
        entities.forEach(x -> dtos.add(om.toDto(x)));
        return dtos;
    }

    public List<Product> fromDto(List<ProductDto> dtos) {
        var result = new LinkedList<Product>();
        dtos.forEach(x -> result.add(om.fromDto(x)));
        return result;
    }
}
