package at.multiflex.dto.traffic;

import at.multiflex.dto.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryColorProducts {
    CategoryDto category;

    List<ProductsWithColor> products = new ArrayList<>();
}
