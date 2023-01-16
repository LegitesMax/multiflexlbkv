package at.multiflex.Dao;

import at.multiflex.dao.CategoryDao;
import at.multiflex.dao.wares.MaterialDao;
import at.multiflex.repository.CategoryRepository;
import at.multiflex.repository.wares.MaterialRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class CategoryDaoTest {
    @Inject
    CategoryDao dao;
    @Inject
    CategoryRepository repo;

    @Test
    public void getAllTest() {
        dao.getAll();
    }
    @Test
    public void getByNameTest() {
        dao.getByName("Blume des Lebens");
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
    public void getAllMaterial() {
        dao.getAllMaterials();
    }
    @Test
    public void getAllProduct() {
        dao.getAllProducts();
    }
}
