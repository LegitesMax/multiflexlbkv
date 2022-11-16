package at.multiflex.dto.logic;

import at.multiflex.dto.wares.ProductDto;
import lombok.*;

/**
 * A Data Transfer Object for the productionLogic
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Production {
   private ProductDto product;

   private Double amount = 1.0;

   private String hashValue;
}
