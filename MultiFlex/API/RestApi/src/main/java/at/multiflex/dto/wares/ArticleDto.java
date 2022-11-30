package at.multiflex.dto.wares;

import at.multiflex.dto.CategoryDto;
import at.multiflex.dto.ColorDto;
import at.multiflex.dto.SizeDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

/**
 * A Data Transfer Object of the class Article
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticleDto {
    //<editor-fold desc="Common Fields">
    private Integer id;

    private String name;

    private Double value;

    private Double minValue;
    //</editor-fold>
    //<editor-fold desc="Navigation Help">

    private SizeDto size = new SizeDto();

    private ColorDto color = new ColorDto();

    private CategoryDto category = new CategoryDto();
    //</editor-fold>


}