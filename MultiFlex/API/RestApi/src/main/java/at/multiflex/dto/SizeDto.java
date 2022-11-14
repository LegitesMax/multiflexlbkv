package at.multiflex.dto;

import at.multiflex.dto.wares.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * A Data Transfer Object of the class Size
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SizeDto {
    //<editor-fold desc="Common Fields">
    private Integer id;

    private Integer size;

    private String description;

    //</editor-fold>
    //<editor-fold desc="Navigation Help">
    private Set<ArticleDto> products = new HashSet<>();
    //</editor-fold>
}
