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

    private Integer value;

    private Integer minValue;
    //</editor-fold>
    //<editor-fold desc="Navigation Help">

    //</editor-fold>
}
