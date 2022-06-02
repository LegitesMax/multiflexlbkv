package at.multiflex.mapper;

import at.multiflex.dto.ColorDto;
import at.multiflex.dto.ProductionFormulaDto;
import at.multiflex.dto.Wares.ArticleDto;
import at.multiflex.dto.Wares.MaterialDto;
import at.multiflex.dto.Wares.ProductDto;
import at.multiflex.model.Color;
import at.multiflex.model.ProductionFormula;
import at.multiflex.model.Wares.Article;
import at.multiflex.model.Wares.Material;
import at.multiflex.model.Wares.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface ObjectMapper {
    //<editor-fold desc="Wares">
    //<editor-fold desc="Article">
    @Mapping(target = "id")
    ArticleDto toDTO(Article entity);

    @Mapping(target = "id")
    Article fromDto(ArticleDto entity);
    //</editor-fold>
    //<editor-fold desc="Material">
    @Mapping(target = "id")
    MaterialDto toDTO(Material entity);

    @Mapping(target = "id")
    Material fromDto(MaterialDto entity);
    //</editor-fold>
    //<editor-fold desc="Product">
    @Mapping(target = "id")
    ProductDto toDTO(Product entity);

    @Mapping(target = "id")
    Product fromDto(ProductDto entity);
    //</editor-fold>
    //</editor-fold>
    //<editor-fold desc="Color">
    @Mapping(target = "id")
    ColorDto toDTO(Color entity);

    @Mapping(target = "id")
    Color fromDto(ColorDto entity);
    //</editor-fold>
    //<editor-fold desc="ProductionFormula">
    @Mapping(target = "id")
    ProductionFormulaDto toDTO(ProductionFormula entity);

    @Mapping(target = "id")
    ProductionFormula fromDto(ProductionFormulaDto entity);
    //</editor-fold>
}

