package at.multiflex.dto;

import at.multiflex.dto.wares.ProductDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

/**
 * A Data Transfer Object for the ProductionLog class
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductionLogDto {
    private Integer id;

    private ProductDto product;
}
