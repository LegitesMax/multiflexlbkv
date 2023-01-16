package at.multiflex.dto.wares;

import at.multiflex.model.Wares.ProductionFormulaId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

/**
 * A Data Transfer Object for the ProductionFormula class
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductionFormulaDto {
    ProductionFormulaId id;

    ProductDto product;

    MaterialDto material;

    private Double amount;
}
