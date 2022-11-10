package at.multiflex.dto.wares;

import at.multiflex.model.Wares.Material;
import at.multiflex.model.Wares.Product;
import at.multiflex.model.Wares.ProductionFormulaId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

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
