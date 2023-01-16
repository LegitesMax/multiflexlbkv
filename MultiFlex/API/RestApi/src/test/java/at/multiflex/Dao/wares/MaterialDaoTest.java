package at.multiflex.Dao.wares;

import at.multiflex.dao.CategoryDao;
import at.multiflex.dao.DaoException;
import at.multiflex.dao.wares.MaterialDao;
import at.multiflex.dto.CategoryDto;
import at.multiflex.dto.logic.Type;
import at.multiflex.dto.wares.MaterialDto;
import at.multiflex.repository.wares.MaterialRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class MaterialDaoTest {
    @Inject
    MaterialDao dao;
    @Inject
    MaterialRepository repo;
    @Inject
    CategoryDao categoryDao;
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
        dao.getById(1000);
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.getById(null);
        });
    }
    @Test
    @TestTransaction
    public void addMaterial_giveNull_throwsIllegalArgumentException() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.add(null);
        });
    }
    @Test
    @TestTransaction
    public void addMaterial_addNewMaterial_Success(){
        var category = new CategoryDto();
        category.setAcronym("TESTM");
        category.setName("TestMaterial");
        category.setType(Type.Product);
        var response = categoryDao.add(category);

        var material = new MaterialDto();
        material.setName("TestMaterial");
        material.setValue(1.0);
        material.setMinValue(2.0);

        var response2 = dao.add(material);

        Assertions.assertEquals(201, response.getStatus());
        Assertions.assertEquals(201, response2.getStatus());
    }
    @Test
    @TestTransaction
    public void deleteMaterial_giveNull_throwsIllegalArgumentException() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.delete(null);
        });
    }
    @Test
    @TestTransaction
    public void deleteMaterial_deleteOneMaterial_Success() {
        addMaterial_addNewMaterial_Success();

        var res = repo.findByName("TestMaterial");

        var response = dao.delete(res.get(0).getId());

        Assertions.assertEquals(204, response.getStatus());
    }
}
