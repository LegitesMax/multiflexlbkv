package at.multiflex.mapper;

import at.multiflex.dto.ColorDto;
import at.multiflex.model.Color;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class ColorMapper {
    @Inject
    ObjectMapper om;

    public ColorDto toDto(Color entity) {
        return om.toDto(entity);
    }
    public Color fromDto(ColorDto dto) {
        return om.fromDto(dto);
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
