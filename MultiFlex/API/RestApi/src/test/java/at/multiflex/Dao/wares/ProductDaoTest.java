package at.multiflex.Dao.wares;

import at.multiflex.dao.CategoryDao;
import at.multiflex.dao.DaoException;
import at.multiflex.dao.wares.MaterialDao;
import at.multiflex.dao.wares.ProductDao;
import at.multiflex.dto.CategoryDto;
import at.multiflex.dto.logic.Type;
import at.multiflex.dto.wares.MaterialDto;
import at.multiflex.dto.wares.ProductDto;
import at.multiflex.repository.wares.MaterialRepository;
import at.multiflex.repository.wares.ProductRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class ProductDaoTest {
    @Inject
    ProductDao dao;
    @Inject
    ProductRepository repo;
    @Inject
    CategoryDao categoryDao;
    @Test
    public void getAllTest() {
        dao.getAll();
    }
    @Test
    public void getByNameTest() {
        dao.getByName("BL 39 34");
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
    public void addProduct_giveNull_throwsIllegalArgumentException() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.add(null);
        });
    }
    @Test
    @TestTransaction
    public void addProduct_addNewProduct_Success(){
        var category = new CategoryDto();
        category.setAcronym("TESTP");
        category.setName("TestProduct");
        category.setType(Type.Material);
        var response = categoryDao.add(category);

        var entity = new ProductDto();
        entity.setName("TESTP 39 BA");
        entity.setValue(1.0);
        entity.setMinValue(2.0);

        var response2 = dao.add(entity);

        Assertions.assertEquals(201, response.getStatus());
        Assertions.assertEquals(201, response2.getStatus());
    }
    @Test
    @TestTransaction
    public void deleteProduct_giveNull_throwsIllegalArgumentException() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.delete(null);
        });
    }
    @Test
    @TestTransaction
    public void deleteProduct_deleteOneProduct_Success() {
        addProduct_addNewProduct_Success();

        var res = repo.findByName("TESTP 39 BA");

        var response = dao.delete(res.get(0).getId());

        Assertions.assertEquals(204, response.getStatus());
    }
}
