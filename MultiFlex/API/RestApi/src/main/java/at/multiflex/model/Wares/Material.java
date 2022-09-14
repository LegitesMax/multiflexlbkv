package at.multiflex.model.Wares;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
    @ManyToMany
    @JoinTable(
            name = "ProductionFormula", // name of the association table
            joinColumns = @JoinColumn(name = "material_id"), // foreign key columns
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;
    //</editor-fold>
}
