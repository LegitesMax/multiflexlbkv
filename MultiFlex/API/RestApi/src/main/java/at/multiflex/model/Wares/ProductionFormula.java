package at.multiflex.model.Wares;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * An entity that contains the amount of material needed for the production of a product
 */
@Getter
@Setter
@Entity
public class ProductionFormula {

    @EmbeddedId
    ProductionFormulaId id;

    @ManyToOne
    @MapsId("productId")
    Product product;

    @ManyToOne
    @MapsId("materialId")
    Material material;

    @Column(nullable = false)
    private Double amount;

}
