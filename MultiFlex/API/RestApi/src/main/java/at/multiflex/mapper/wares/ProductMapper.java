package at.multiflex.mapper.wares;

import at.multiflex.dto.wares.ProductDto;
import at.multiflex.mapper.ObjectMapper;
import at.multiflex.model.Wares.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class ProductMapper {
    @Inject
    ObjectMapper om;

    public ProductDto toDto(Product entity) {
        return om.toDto(entity);
    }
    public Product fromDto(ProductDto dto) {
        return om.fromDto(dto);
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
