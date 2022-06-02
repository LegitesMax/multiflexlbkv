package at.multiflex.model;

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
public class Product extends Article{
    @Transient
    private Integer productionFormula_id = configurateProductId();

    @OneToOne
    @JoinColumn(name = "productionFormula_id", nullable = false)
    private ProductionFormula productionFormula;

    private Integer configurateProductId(){
        if (getProductionFormula() != null && getProductionFormula().getId() != null){
            return getProductionFormula().getId();
        }
        return null;
    }
}
