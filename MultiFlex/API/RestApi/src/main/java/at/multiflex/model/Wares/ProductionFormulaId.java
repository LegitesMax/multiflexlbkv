package at.multiflex.model.Wares;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ProductionFormulaId implements Serializable {
    @Column
    Integer productId;

    @Column
    Integer materialId;

}
