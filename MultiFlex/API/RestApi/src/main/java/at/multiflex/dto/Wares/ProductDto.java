package at.multiflex.dto.Wares;

import at.multiflex.dto.Wares.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends ArticleDto {
    //<editor-fold desc="Navigation Help">
    private Integer productionFormula_id;
    //</editor-fold>
}
