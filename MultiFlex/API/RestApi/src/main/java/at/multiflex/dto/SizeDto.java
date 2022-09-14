package at.multiflex.dto;

import at.multiflex.dto.wares.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SizeDto {
    //<editor-fold desc="Common Fields">
    private Integer id;

    private Integer size;

    //</editor-fold>
    //<editor-fold desc="Navigation Help">
    private List<Integer> product_ids = new ArrayList<>();

    private Set<ProductDto> products = new HashSet<>();
    //</editor-fold>
}
