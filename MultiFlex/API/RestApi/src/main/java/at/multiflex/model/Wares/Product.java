package at.multiflex.model.Wares;

import at.multiflex.model.ProductionFormula;
import at.multiflex.model.Wares.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product extends Article {
    //<editor-fold desc="Common Fields">

    //</editor-fold>
    //<editor-fold desc="Navigation Help">
        //<editor-fold desc="Transient Fields">
    @Transient
    private Integer productionFormula_id = configurateProductId();
        //</editor-fold>
        //<editor-fold desc="Relation">
    @OneToOne
    @JoinColumn(name = "productionFormula_id", nullable = false)
    private ProductionFormula productionFormula;
        //</editor-fold>
        //<editor-fold desc="Transient Field configuration">
    private Integer configurateProductId(){
        if (getProductionFormula() != null && getProductionFormula().getId() != null){
            return getProductionFormula().getId();
        }
        return null;
    }
        //</editor-fold>
    //</editor-fold>
}
