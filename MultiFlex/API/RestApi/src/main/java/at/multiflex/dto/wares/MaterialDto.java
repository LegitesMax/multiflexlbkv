package at.multiflex.dto.wares;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * A Data Transfer Object of the class Material
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MaterialDto extends ArticleDto {
    //<editor-fold desc="Navigation Help">
    private Set<ProductionFormulaDto> productionFormula = new HashSet<>();
    //</editor-fold>
}
