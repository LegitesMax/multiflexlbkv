package at.multiflex.dto.wares;

import at.multiflex.model.Wares.ProductionFormulaId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductionFormulaDto {
    ProductionFormulaId id;

    ProductDto product;

    MaterialDto material;

    private Double amount;
}
