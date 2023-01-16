package at.multiflex.dto;

import at.multiflex.dto.logic.Type;
import at.multiflex.dto.wares.ArticleDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * A Data Transfer Object of the class Category
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CategoryDto {
    //<editor-fold desc="Common Fields">
    private Integer id;

    private String name;

    private String acronym;

    private Type type;
    //</editor-fold>
    //<editor-fold desc="Navigation Help">

    private Set<ArticleDto> products = new HashSet<>();
    //</editor-fold>
}
