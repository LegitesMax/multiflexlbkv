package at.multiflex.dto.wares;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * A Data Transfer Object of the class Material
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDto extends ArticleDto {
    //<editor-fold desc="Navigation Help">
    private Set<ProductDto> products = new HashSet<>();
    //</editor-fold>
}
