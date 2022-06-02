package at.multiflex.mapper;

import at.multiflex.dto.ColorDto;
import at.multiflex.dto.wares.ArticleDto;
import at.multiflex.dto.wares.MaterialDto;
import at.multiflex.dto.wares.ProductDto;
import at.multiflex.model.Color;
import at.multiflex.model.Wares.Article;
import at.multiflex.model.Wares.Material;
import at.multiflex.model.Wares.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface ObjectMapper {
    //<editor-fold desc="Wares">
    //<editor-fold desc="ArticleRepository">
    @Mapping(target = "id")
    ArticleDto toDto(Article entity);

    @Mapping(target = "id")
    Article fromDto(ArticleDto entity);
    //</editor-fold>
    //<editor-fold desc="Material">
    @Mapping(target = "id")
    MaterialDto toDto(Material entity);

    @Mapping(target = "id")
    Material fromDto(MaterialDto entity);
    //</editor-fold>
    //<editor-fold desc="Product">
    @Mapping(target = "id")
    ProductDto toDto(Product entity);

    @Mapping(target = "id")
    Product fromDto(ProductDto entity);
    //</editor-fold>
    //</editor-fold>
    //<editor-fold desc="Color">
    @Mapping(target = "id")
    ColorDto toDto(Color entity);

    @Mapping(target = "id")
    Color fromDto(ColorDto entity);
    //</editor-fold>
}

