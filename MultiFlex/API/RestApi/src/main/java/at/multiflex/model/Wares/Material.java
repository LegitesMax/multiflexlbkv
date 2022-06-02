package at.multiflex.model.Wares;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Material")
public class Material extends Article {
    //<editor-fold desc="Common Fields">

    //</editor-fold>
    //<editor-fold desc="Navigation Help">
        //<editor-fold desc="Transient Fields">
    @Transient
    private List<Integer> product_ids = configurateProductIds();
        //</editor-fold>
        //<editor-fold desc="Relation">
    @ManyToMany
    @JoinTable(
            name = "ProductionFormula", // name of the association table
            joinColumns = @JoinColumn(name = "material_id"), // foreign key columns
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;
        //</editor-fold>
        //<editor-fold desc="Transient Field configuration">
    private List<Integer> configurateProductIds(){
        if (getProducts() != null){
            return getProducts().stream().map(x -> x.getId()).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
        //</editor-fold>
    //</editor-fold>
}
