package at.multiflex.model.Wares;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    @JsonBackReference
    Product product;

    @ManyToOne
    @MapsId("materialId")
    @JsonBackReference
    Material material;

    @Column(nullable = false)
    private Double amount;

    @Override
    public String toString() {
        return "ProductionFormula{" +
                "id=" + id.toString() +
                ", amount=" + amount +
                '}';
    }
}
