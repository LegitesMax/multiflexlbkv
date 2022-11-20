package at.multiflex.dto.wares;

import at.multiflex.dto.ProductionLogDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * A Data Transfer Object of the class Product
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto extends ArticleDto {
    //<editor-fold desc="Navigation Help">

    private Set<ProductionFormulaDto> productionFormula = new HashSet<>();


    private Set<ProductionLogDto> productionLog = new HashSet<>();
    //</editor-fold>
}
