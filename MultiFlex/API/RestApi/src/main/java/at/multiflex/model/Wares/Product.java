package at.multiflex.model.Wares;

import at.multiflex.dto.logic.Type;
import at.multiflex.model.ProductionLog;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * This Product class gets inserted into the database
 */
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Product")
public class Product extends Article {
    //<editor-fold desc="Common Fields">

    public Product() {
    }

    //</editor-fold>
    //<editor-fold desc="Relation">
    //@ManyToMany(fetch = FetchType.EAGER, mappedBy = "products")
    //private Set<Material> materials = new java.util.LinkedHashSet<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JsonManagedReference
    private Set<ProductionFormula> productionFormula = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade=CascadeType.ALL)
    @JsonManagedReference
    private Set<ProductionLog> productionLog = new java.util.LinkedHashSet<>();
    //</editor-fold>

    @Override
    public String toString() {
        return "Product{" +
                "productionFormula=" + productionFormula +
                ", productionLog=" + productionLog +
                super.toString() +
                '}';
    }
}
