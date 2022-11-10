package at.multiflex.dto.wares;

import at.multiflex.dto.CategoryDto;
import at.multiflex.dto.ColorDto;
import at.multiflex.dto.ProductionLogDto;
import at.multiflex.dto.SizeDto;
import at.multiflex.model.ProductionLog;
import at.multiflex.model.Wares.ProductionFormula;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * A Data Transfer Object of the class Product
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends ArticleDto {
    //<editor-fold desc="Navigation Help">
    private Set<ProductionFormulaDto> productionFormula = new HashSet<>();

    private Set<ProductionLogDto> productionLog = new HashSet<>();
    //</editor-fold>
}
