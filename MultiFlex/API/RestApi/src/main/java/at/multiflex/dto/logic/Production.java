package at.multiflex.dto.logic;

import at.multiflex.dto.wares.ProductDto;
import at.multiflex.model.Wares.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Production {
   private ProductDto product;

   private Double amount = 1.0;
}
