package at.multiflex.dto.logic;

import at.multiflex.dto.wares.ProductDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
   @JsonBackReference
   @JsonManagedReference
   private ProductDto product;

   private Double amount = 1.0;

   private String hashValue;
}
