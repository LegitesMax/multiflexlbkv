package at.multiflex.dto;

import at.multiflex.dto.wares.ProductDto;
import lombok.*;

/**
 * A Data Transfer Object for the ProductionLog class
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductionLogDto {
    private Integer id;

    private ProductDto product;
}
