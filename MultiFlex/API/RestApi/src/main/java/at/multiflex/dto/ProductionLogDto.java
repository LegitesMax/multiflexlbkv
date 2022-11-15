package at.multiflex.dto;

import at.multiflex.dto.wares.ProductDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductionLogDto {
    private Integer id;

    private ProductDto product;
}
