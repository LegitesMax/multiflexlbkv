package at.multiflex.mapper;

import at.multiflex.dto.ProductionFormulaDto;
import at.multiflex.model.ProductionFormula;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class ProductionFormulaMapper {
    @Inject
    ObjectMapper om;

    public ProductionFormulaDto toDto(ProductionFormula entity) {
        return om.toDto(entity);
    }
    public ProductionFormula fromDto(ProductionFormulaDto dto) {
        return om.fromDto(dto);
    }

    public List<ProductionFormulaDto> toDto(List<ProductionFormula> entities) {
        var dtos = new LinkedList<ProductionFormulaDto>();
        entities.forEach(x -> dtos.add(om.toDto(x)));
        return dtos;
    }

    public List<ProductionFormula> fromDto(List<ProductionFormulaDto> dtos) {
        var result = new LinkedList<ProductionFormula>();
        dtos.forEach(x -> result.add(om.fromDto(x)));
        return result;
    }
}
