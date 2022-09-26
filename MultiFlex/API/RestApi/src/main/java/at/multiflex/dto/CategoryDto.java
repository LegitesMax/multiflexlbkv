package at.multiflex.dto;

import at.multiflex.dto.wares.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * A Data Transfer Object of the class Category
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    //<editor-fold desc="Common Fields">
    private Integer id;

    private String name;

    private String acronym;

    //</editor-fold>
    //<editor-fold desc="Navigation Help">
    private Set<ProductDto> products = new HashSet<>();
    //</editor-fold>
}
