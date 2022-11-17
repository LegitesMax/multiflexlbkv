package at.multiflex.dto;

import at.multiflex.dto.wares.ArticleDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * A Data Transfer Object of the class Size
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SizeDto {
    //<editor-fold desc="Common Fields">
    private Integer id;

    private Integer size;

    private String description;

    //</editor-fold>
    //<editor-fold desc="Navigation Help">
    @JsonBackReference
    @JsonManagedReference
    private Set<ArticleDto> products = new HashSet<>();
    //</editor-fold>
}
