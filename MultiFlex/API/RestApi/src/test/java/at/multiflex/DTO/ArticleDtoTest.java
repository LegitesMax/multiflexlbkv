package at.multiflex.DTO;

import at.multiflex.dto.wares.ArticleDto;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ArticleDtoTest {
    @Test
    public void articleTest(){
        var dto = new ArticleDto();
        dto.toString();
    }
}
