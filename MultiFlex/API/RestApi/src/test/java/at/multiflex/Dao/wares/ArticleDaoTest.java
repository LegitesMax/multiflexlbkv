package at.multiflex.Dao.wares;

import at.multiflex.dao.DaoException;
import at.multiflex.dao.wares.ArticleDao;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class ArticleDaoTest {
    @Inject
    ArticleDao dao;
    @Test
    public void getAllTest() throws DaoException {
        dao.getAll();
    }
    @Test
    public void getByNameTest() throws DaoException {
        dao.getByName("Holz");
    }
    @Test
    public void getByIdTest() throws DaoException {
        dao.getById(1);
    }
}
