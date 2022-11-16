package at.multiflex.model.Wares;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * This Material class gets inserted into the database
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Material")
public class Material extends Article {
    //<editor-fold desc="Common Fields">

    //</editor-fold>

    //<editor-fold desc="Relation">
    /*
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ProductionFormulaDto", // name of the association table
            joinColumns = @JoinColumn(name = "material_id"), // foreign key columns
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;
    */
    @OneToMany(mappedBy = "material", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Set<ProductionFormula> productionFormula = new HashSet<>();
    //</editor-fold>

    @Override
    public String toString() {
        return "Material{" +
                "productionFormula=" + productionFormula +
                super.toString() +
                '}';
    }
}
