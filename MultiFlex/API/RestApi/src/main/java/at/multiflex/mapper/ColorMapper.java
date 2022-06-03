package at.multiflex.mapper;

import at.multiflex.dto.ColorDto;
import at.multiflex.model.Color;
import at.multiflex.repository.wares.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class ColorMapper {
    @Inject
    ObjectMapper om;

    @Inject
    ProductRepository productRepository;

    public ColorDto toDto(Color entity) {
        return om.toDto(entity);
    }
    public Color fromDto(ColorDto dto) {
        var entity = om.fromDto(dto);

        if (dto.getProduct_ids() != null){
            entity.getProducts().forEach(x -> entity.getProducts().add(productRepository.findById(x.getId())));
        }

        return entity;
    }

    public List<ColorDto> toDto(List<Color> entities) {
        var dtos = new LinkedList<ColorDto>();
        entities.forEach(x -> dtos.add(om.toDto(x)));
        return dtos;
    }

    public List<Color> fromDto(List<ColorDto> dtos) {
        var result = new LinkedList<Color>();
        dtos.forEach(x -> result.add(om.fromDto(x)));
        return result;
    }
}
