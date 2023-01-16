package at.multiflex.model.Wares;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * This class generates the id for the ProductionFormulaDto
 */
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ProductionFormulaId implements Serializable {
    /**
     * The first part of the id
     */
    @Column
    Integer productId;

    /**
     * The second part of the id
     */
    @Column
    Integer materialId;

}
