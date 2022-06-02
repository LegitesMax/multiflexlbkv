package at.multiflex.dto.wares;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    //<editor-fold desc="Common Fields">
    private Integer id;

    private String name;

    private Integer Value;

    private Integer minValue;
    //</editor-fold>
    //<editor-fold desc="Navigation Help">
    private Integer color_id;
    //</editor-fold>
}
