package at.multiflex.dto.traffic;

import at.multiflex.dto.wares.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsWithColor extends ArticleDto {
    private List<Integer> material_ids;

    private String colorName;

    private String colorCode;
}
