package at.multiflex.dto;

import at.multiflex.dto.wares.ProductDto;
import at.multiflex.model.Wares.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductionLogDto {
    private Integer id;

    private ProductDto product;
}
