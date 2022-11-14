package at.multiflex.model.Wares;

import at.multiflex.model.ProductionLog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * This Product class gets inserted into the database
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product extends Article {
    //<editor-fold desc="Common Fields">

    //</editor-fold>
    //<editor-fold desc="Relation">
    //@ManyToMany(fetch = FetchType.EAGER, mappedBy = "products")
    //private Set<Material> materials = new java.util.LinkedHashSet<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Set<ProductionFormula> productionFormula = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade=CascadeType.ALL)
    private Set<ProductionLog> productionLog = new java.util.LinkedHashSet<>();
    //</editor-fold>
}
