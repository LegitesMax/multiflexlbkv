package at.multiflex.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductionFormulaDto {
    //<editor-fold desc="Common Fields">
    private Integer id;
    //</editor-fold>
    //<editor-fold desc="Navigation Help">
    private Integer product_id;

    private List<Integer> material_ids;
    //</editor-fold>
}
