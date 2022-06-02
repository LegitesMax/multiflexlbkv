package at.multiflex.dto.Wares;

import at.multiflex.dto.Wares.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDto extends ArticleDto {
    //<editor-fold desc="Navigation Help">
    private List<Integer> productionFormula_ids;
    //</editor-fold>
}
