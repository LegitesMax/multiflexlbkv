package at.multiflex.dto.Wares;

import at.multiflex.model.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
