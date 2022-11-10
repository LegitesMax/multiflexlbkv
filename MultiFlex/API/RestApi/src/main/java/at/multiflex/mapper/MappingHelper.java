package at.multiflex.mapper;

import at.multiflex.dto.CategoryDto;
import at.multiflex.dto.ColorDto;
import at.multiflex.dto.ProductionLogDto;
import at.multiflex.dto.SizeDto;
import at.multiflex.dto.wares.ArticleDto;
import at.multiflex.dto.wares.MaterialDto;
import at.multiflex.dto.wares.ProductDto;
import at.multiflex.dto.wares.ProductionFormulaDto;
import at.multiflex.model.Category;
import at.multiflex.model.Color;
import at.multiflex.model.ProductionLog;
import at.multiflex.model.Size;
import at.multiflex.model.Wares.Article;
import at.multiflex.model.Wares.Material;
import at.multiflex.model.Wares.Product;
import at.multiflex.model.Wares.ProductionFormula;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic method to help with the mapping from dto to entity and vice versa
 */
public class MappingHelper {
    /**
     * This method transforms a list of entities to a list of dtos and vice versa
     * @param entities a list of entities or dtos to transform
     * @param <T> A generic type T
     * @return A list containing the converted entities
     */
    public static <T> List<Object> entityDtoTransformation(List<T> entities) {
        var dtos = new ArrayList<Object>();

        for (var entity:entities) {
            dtos.add(entityDtoTransformation(entity));
        }

        return dtos;
    }

    /**
     * This method transforms an entity to a dto and a dto to an entity
     * @param entity the entity or the dto to convert
     * @param <T> A generic type T
     * @return The converted entity or dto
     */
    public static <T> Object entityDtoTransformation(T entity) {
        var result = new Object();
        //region toDto
        if (entity.getClass() == Article.class){
            result = (ObjectMapper.MAPPER.toDto((Article) entity));
        }
        else if (entity.getClass() == Material.class){
            result = (ObjectMapper.MAPPER.toDto((Material) entity));
        }
        else if (entity.getClass() == Product.class){
            result = (ObjectMapper.MAPPER.toDto((Product) entity));
        }
        else if (entity.getClass() == Category.class){
            result = (ObjectMapper.MAPPER.toDto((Category) entity));
        }
        else if (entity.getClass() == Color.class){
            result = (ObjectMapper.MAPPER.toDto((Color) entity));
        }
        else if (entity.getClass() == Size.class){
            result = (ObjectMapper.MAPPER.toDto((Size) entity));
        }
        else if (entity.getClass() == ProductionLog.class){
            result = (ObjectMapper.MAPPER.toDto((ProductionLog) entity));
        }
        else if (entity.getClass() == ProductionFormula.class){
            result = (ObjectMapper.MAPPER.toDto((ProductionFormula) entity));
        }
        //endregion
        //region fromDto
        if (entity.getClass() == ArticleDto.class){
            result = (ObjectMapper.MAPPER.fromDto((ArticleDto) entity));
        }
        else if (entity.getClass() == MaterialDto.class){
            result = (ObjectMapper.MAPPER.fromDto((MaterialDto) entity));
        }
        else if (entity.getClass() == ProductDto.class){
            result = (ObjectMapper.MAPPER.fromDto((ProductDto) entity));
        }
        else if (entity.getClass() == CategoryDto.class){
            result = (ObjectMapper.MAPPER.fromDto((CategoryDto) entity));
        }
        else if (entity.getClass() == ColorDto.class){
            result = (ObjectMapper.MAPPER.fromDto((ColorDto) entity));
        }
        else if (entity.getClass() == SizeDto.class){
            result = (ObjectMapper.MAPPER.fromDto((SizeDto) entity));
        }
        else if (entity.getClass() == ProductionLogDto.class){
            result = (ObjectMapper.MAPPER.fromDto((ProductionLogDto) entity));
        }
        else if (entity.getClass() == ProductionFormulaDto.class){
            result = (ObjectMapper.MAPPER.fromDto((ProductionFormulaDto) entity));
        }
        //endregion
        return result;
    }
}
