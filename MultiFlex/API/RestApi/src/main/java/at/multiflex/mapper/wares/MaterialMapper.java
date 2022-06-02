package at.multiflex.mapper.wares;

import at.multiflex.dto.wares.MaterialDto;
import at.multiflex.mapper.ObjectMapper;
import at.multiflex.model.Wares.Material;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class MaterialMapper {
    @Inject
    ObjectMapper om;

    public MaterialDto toDto(Material entity) {
        return om.toDto(entity);
    }
    public Material fromDto(MaterialDto dto) {
        return om.fromDto(dto);
    }

    public List<MaterialDto> toDto(List<Material> entities) {
        var dtos = new LinkedList<MaterialDto>();
        entities.forEach(x -> dtos.add(om.toDto(x)));
        return dtos;
    }

    public List<Material> fromDto(List<MaterialDto> dtos) {
        var result = new LinkedList<Material>();
        dtos.forEach(x -> result.add(om.fromDto(x)));
        return result;
    }
}
