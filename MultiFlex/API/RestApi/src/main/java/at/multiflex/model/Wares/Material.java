package at.multiflex.model.Wares;

import at.multiflex.model.ProductionFormula;
import at.multiflex.model.Wares.Article;
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
    private List<Integer> productionFormula_ids = configurateProductionFormulaIds();
        //</editor-fold>
        //<editor-fold desc="Relation">
    @ManyToMany
    @JoinTable(
            name = "Material_ProductionFormula", // name of the association table
            joinColumns = @JoinColumn(name = "material_id"), // foreign key columns
            inverseJoinColumns = @JoinColumn(name = "productionFormulas_id"))
    private Set<ProductionFormula> productionFormulas;
        //</editor-fold>
        //<editor-fold desc="Transient Field configuration">
    private List<Integer> configurateProductionFormulaIds(){
        if (getProductionFormulas() != null){
            return getProductionFormulas().stream().map(x -> x.getId()).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
        //</editor-fold>
    //</editor-fold>
}
