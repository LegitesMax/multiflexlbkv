package at.multiflex.mapper;

import at.multiflex.dto.CategoryDto;
import at.multiflex.dto.ColorDto;
import at.multiflex.dto.SizeDto;
import at.multiflex.dto.wares.ArticleDto;
import at.multiflex.dto.wares.MaterialDto;
import at.multiflex.dto.wares.ProductDto;
import at.multiflex.model.Category;
import at.multiflex.model.Color;
import at.multiflex.model.Size;
import at.multiflex.model.Wares.Article;
import at.multiflex.model.Wares.Material;
import at.multiflex.model.Wares.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

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

    @Named("toDtoIgnoreParent")
    //@Mapping(target = "products", ignore = true)
    MaterialDto toDtoIgnoreParent(Material entity);

    @Named("fromDtoIgnoreParent")
    //@Mapping(target = "products", ignore = true)
    Material fromDtoIgnoreParent(MaterialDto entity);
    //</editor-fold>
    //<editor-fold desc="Product">
    //@Mapping(target = "id")
    @Mapping(target = "size", qualifiedByName = {"toDtoIgnoreParent"})
    @Mapping(target = "color", qualifiedByName = {"toDtoIgnoreParent"})
    @Mapping(target = "materials", qualifiedByName = {"toDtoIgnoreParent"})
    @Mapping(target = "category", qualifiedByName = {"toDtoIgnoreParent"})
    ProductDto toDto(Product entity);

    //@Mapping(target = "id")
    @Mapping(target = "size", qualifiedByName = {"fromDtoIgnoreParent"})
    @Mapping(target = "color", qualifiedByName = {"fromDtoIgnoreParent"})
    @Mapping(target = "materials", qualifiedByName = {"fromDtoIgnoreParent"})
    @Mapping(target = "category", qualifiedByName = {"fromDtoIgnoreParent"})
    Product fromDto(ProductDto entity);
    //</editor-fold>
    //</editor-fold>
    //<editor-fold desc="Color">
    @Mapping(target = "id")
    ColorDto toDto(Color entity);

    @Mapping(target = "id")
    Color fromDto(ColorDto entity);

    @Named("toDtoIgnoreParent")
    @Mapping(target = "products", ignore = true)
    ColorDto toDtoIgnoreParent(Color entity);

    @Named("fromDtoIgnoreParent")
    @Mapping(target = "products", ignore = true)
    Color fromDtoIgnoreParent(ColorDto entity);
    //</editor-fold>
    //<editor-fold desc="Category">
    @Mapping(target = "id")
    CategoryDto toDto(Category entity);

    @Mapping(target = "id")
    Category fromDto(CategoryDto entity);

    @Named("toDtoIgnoreParent")
    @Mapping(target = "products", ignore = true)
    CategoryDto toDtoIgnoreParent(Category entity);

    @Named("fromDtoIgnoreParent")
    @Mapping(target = "products", ignore = true)
    Category fromDtoIgnoreParent(CategoryDto entity);
    //</editor-fold>
    //<editor-fold desc="Size">
    @Mapping(target = "id")
    SizeDto toDto(Size entity);

    @Mapping(target = "id")
    Size fromDto(SizeDto entity);

    @Named("toDtoIgnoreParent")
    @Mapping(target = "products", ignore = true)
    SizeDto toDtoIgnoreParent(Size entity);

    @Named("fromDtoIgnoreParent")
    @Mapping(target = "products", ignore = true)
    Size fromDtoIgnoreParent(SizeDto entity);
    //</editor-fold>
    //region Lists
    //<editor-fold desc="Material">
    @Mapping(target = "id")
    List<MaterialDto> toDto(List<Material> entity);

    @Mapping(target = "id")
    List<Material> fromDto(List<MaterialDto> entity);

    @Named("toDtoIgnoreParent")
        @Mapping(target = "products", ignore = true)
    List<MaterialDto> toDtoIgnoreParent(List<Material> entity);

    @Named("fromDtoIgnoreParent")
        @Mapping(target = "products", ignore = true)
    List<Material> fromDtoIgnoreParent(List<MaterialDto> entity);

    @Mapping(target = "id")
    Set<MaterialDto> toDto(Set<Material> entity);

    @Mapping(target = "id")
    Set<Material> fromDto(Set<MaterialDto> entity);

    @Named("toDtoIgnoreParent")
    @Mapping(target = "products", ignore = true)
    Set<MaterialDto> toDtoIgnoreParent(Set<Material> entity);

    @Named("fromDtoIgnoreParent")
    @Mapping(target = "products", ignore = true)
    Set<Material> fromDtoIgnoreParent(Set<MaterialDto> entity);
    //</editor-fold>
    //endregion
}

