package at.multiflex.dto.logic;

import at.multiflex.dto.wares.ProductDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Production {
   private ProductDto product;

   private Double amount = 1.0;
}
