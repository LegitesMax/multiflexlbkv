package at.multiflex.dto.wares;

import at.multiflex.dto.CategoryDto;
import at.multiflex.dto.ColorDto;
import at.multiflex.dto.SizeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends ArticleDto {
    //<editor-fold desc="Navigation Help">
    private Set<MaterialDto> materials = new HashSet<>();
    private SizeDto size = new SizeDto();
    private ColorDto color = new ColorDto();
    private CategoryDto category = new CategoryDto();
    //</editor-fold>
}
