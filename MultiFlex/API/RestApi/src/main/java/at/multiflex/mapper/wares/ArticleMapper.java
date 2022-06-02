package at.multiflex.mapper.wares;

import at.multiflex.dto.wares.ArticleDto;
import at.multiflex.mapper.ObjectMapper;
import at.multiflex.model.Wares.Article;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class ArticleMapper {
    @Inject
    ObjectMapper om;

    public ArticleDto toDto(Article entity) {
        return om.toDto(entity);
    }
    public Article fromDto(ArticleDto dto) {
        return om.fromDto(dto);
    }

    public List<ArticleDto> toDto(List<Article> entities) {
        var dtos = new LinkedList<ArticleDto>();
        entities.forEach(x -> dtos.add(om.toDto(x)));
        return dtos;
    }

    public List<Article> fromDto(List<ArticleDto> dtos) {
        var result = new LinkedList<Article>();
        dtos.forEach(x -> result.add(om.fromDto(x)));
        return result;
    }
}
