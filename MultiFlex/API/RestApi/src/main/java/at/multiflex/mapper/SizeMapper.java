package at.multiflex.mapper;

import at.multiflex.dto.CategoryDto;
import at.multiflex.dto.SizeDto;
import at.multiflex.model.Category;
import at.multiflex.model.Size;
import at.multiflex.repository.wares.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class SizeMapper {
    @Inject
    ObjectMapper om;

    @Inject
    ProductRepository productRepository;

    public SizeDto toDto(Size entity) {
        return om.toDto(entity);
    }
    public Size fromDto(SizeDto dto) {
        var entity = om.fromDto(dto);

        if (dto.getProduct_ids() != null){
            entity.getProducts().forEach(x -> entity.getProducts().add(productRepository.findById(x.getId())));
        }

        return entity;
    }

    public List<SizeDto> toDto(List<Size> entities) {
        var dtos = new LinkedList<SizeDto>();
        entities.forEach(x -> dtos.add(om.toDto(x)));
        return dtos;
    }

    public List<Size> fromDto(List<SizeDto> dtos) {
        var result = new LinkedList<Size>();
        dtos.forEach(x -> result.add(om.fromDto(x)));
        return result;
    }
}
