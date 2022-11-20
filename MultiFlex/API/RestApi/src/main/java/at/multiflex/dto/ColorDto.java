package at.multiflex.dto;

import at.multiflex.dto.wares.ArticleDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * A Data Transfer Object of the class Color
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ColorDto {
    //<editor-fold desc="Common Fields">
    private Integer id;

    private String name;

    private String colorCode;
    //</editor-fold>
    //<editor-fold desc="Navigation Help">
    private Set<ArticleDto> products = new HashSet<>();
    //</editor-fold>
}
