package at.multiflex.Dao.wares;

import at.multiflex.dao.DaoException;
import at.multiflex.dao.wares.ArticleDao;
import at.multiflex.dto.wares.ArticleDto;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

@QuarkusTest
public class ArticleDaoTest {
    @Inject
    ArticleDao dao;
    @Test
    public void getAllTest() {
        dao.getAll();
    }
    @Test
    public void getByNameTest() {
        dao.getByName("Holz");
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.getByName(null);
        });
    }
    @Test
    public void getByIdTest() {
        dao.getById(1);
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.getById(null);
        });
    }
    @Test
    @TestTransaction
    public void updateArticle_updateArticle_Success() {
        var dto = new ArticleDto();
        dto.setId(1000);
        dto.setName("Holz 39");
        dto.setValue(1000.0);
        var response = dao.update(dto);

        var dto2 = new ArticleDto();
        dto2.setId(1000);
        dto2.setMinValue(100.0);

        var response2 = dao.update(dto2);

        Assertions.assertEquals(200, response.getStatus());
        Assertions.assertEquals(200, response2.getStatus());
    }
    @Test
    @TestTransaction
    public void updateArticle_giveNull_throwsIllegalArgumentException() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.update(null);
        });
    }
}
