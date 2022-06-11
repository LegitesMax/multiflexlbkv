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
public class ProductDto extends ArticleDto {
    //<editor-fold desc="Navigation Help">
    private List<Integer> material_ids;

    private List<Integer> size_ids;

    private Integer color_id;

    private Integer category_id;
    //</editor-fold>
}
