package at.multiflex.dto.wares;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    @JsonManagedReference
    private Set<ProductionFormulaDto> productionFormula = new HashSet<>();
    //</editor-fold>
}
