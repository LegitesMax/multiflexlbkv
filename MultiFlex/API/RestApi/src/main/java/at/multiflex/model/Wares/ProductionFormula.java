package at.multiflex.model.Wares;

import javax.persistence.*;

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
