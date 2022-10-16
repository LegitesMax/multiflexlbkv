package at.multiflex.dto.wares;

import at.multiflex.dto.CategoryDto;
import at.multiflex.dto.ColorDto;
import at.multiflex.dto.SizeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A Data Transfer Object of the class Article
 */
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
    private SizeDto size = new SizeDto();
    private ColorDto color = new ColorDto();
    private CategoryDto category = new CategoryDto();
    //</editor-fold>


}
