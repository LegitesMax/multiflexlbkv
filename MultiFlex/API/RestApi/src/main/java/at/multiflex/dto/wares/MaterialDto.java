package at.multiflex.dto.wares;

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
    private List<Integer> product_ids;
    //</editor-fold>
}
