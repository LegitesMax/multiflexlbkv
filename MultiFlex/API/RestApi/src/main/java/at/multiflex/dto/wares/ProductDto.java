package at.multiflex.dto.wares;

import at.multiflex.dto.ProductionLogDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * A Data Transfer Object of the class Product
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends ArticleDto {
    //<editor-fold desc="Navigation Help">
    private Set<ProductionFormulaDto> productionFormula = new HashSet<>();

    private Set<ProductionLogDto> productionLog = new HashSet<>();
    //</editor-fold>
}
