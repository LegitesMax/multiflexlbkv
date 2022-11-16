package at.multiflex.dto.wares;

import at.multiflex.model.Wares.ProductionFormulaId;
import lombok.*;

/**
 * A Data Transfer Object for the ProductionFormula class
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductionFormulaDto {
    ProductionFormulaId id;

    ProductDto product;

    MaterialDto material;

    private Double amount;
}
