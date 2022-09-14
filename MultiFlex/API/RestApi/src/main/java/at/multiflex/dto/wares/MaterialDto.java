package at.multiflex.dto.wares;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDto extends ArticleDto {
    //<editor-fold desc="Navigation Help">
    private Set<ProductDto> products = new HashSet<>();
    //</editor-fold>
}
