package at.multiflex.Dao;

import at.multiflex.dao.CategoryDao;
import at.multiflex.dao.DaoException;
import at.multiflex.dao.wares.MaterialDao;
import at.multiflex.dto.CategoryDto;
import at.multiflex.dto.logic.Type;
import at.multiflex.dto.wares.ProductDto;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.repository.CategoryRepository;
import at.multiflex.repository.wares.MaterialRepository;
import io.quarkus.test.TestTransaction;
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
    @Test
    @TestTransaction
    public void addCategory_giveNull_throwsIllegalArgumentException() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.add(null);
        });
    }
    @Test
    @TestTransaction
    public void addCategory_addNewCategory_Success(){
        var category = new CategoryDto();
        category.setAcronym("TESTP");
        category.setName("TestProduct");
        category.setType(Type.Material);
        var response = dao.add(category);

        Assertions.assertEquals(201, response.getStatus());
    }
    @Test
    @TestTransaction
    public void deleteCategory_giveNull_throwsIllegalArgumentException() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.delete(null);
        });
    }
    @Test
    @TestTransaction
    public void deleteCategory_deleteOneCategory_Success() throws DaoException {
        addCategory_addNewCategory_Success();

        var res = repo.findByName("TestProduct");

        var response = dao.delete(res.getId());

        Assertions.assertEquals(204, response.getStatus());
    }
    @Test
    @TestTransaction
    public void updateCategoryByName_giveNull_throwsIllegalArgumentException() throws DaoException {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.updateByName(null);
        });
    }
    @Test
    @TestTransaction
    public void updateCategoryByName_updateOneCategory_Success() throws DaoException {
        addCategory_addNewCategory_Success();

        var res = repo.findByName("TestProduct");

        res.setType(null);

        var response = dao.updateByName((CategoryDto) MappingHelper.entityDtoTransformation(res));
        var response2 = dao.updateByName((CategoryDto) MappingHelper.entityDtoTransformation(res));

        Assertions.assertEquals(200, response.getStatus());
        Assertions.assertEquals(200, response2.getStatus());
    }
    @Test
    @TestTransaction
    public void updateCategoryByName_updateOneCategory2_Success() throws DaoException {
        addCategory_addNewCategory_Success();

        var res = repo.findByName("TestProduct");

        res.setAcronym(null);

        var response = dao.updateByName((CategoryDto) MappingHelper.entityDtoTransformation(res));

        Assertions.assertEquals(200, response.getStatus());
    }
    @Test
    @TestTransaction
    public void updateCategoryById_giveNull_throwsIllegalArgumentException() throws DaoException {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.update(null);
        });
    }
    @Test
    @TestTransaction
    public void updateCategoryById_updateOneCategory_Success() throws DaoException {
        addCategory_addNewCategory_Success();

        var res = (CategoryDto) MappingHelper.entityDtoTransformation(repo.findByName("TestProduct"));

        res.setName(null);
        res.setAcronym(null);

        var response = dao.update(res);

        Assertions.assertEquals(200, response.getStatus());
    }
    @Test
    @TestTransaction
    public void updateCategoryById_updateOneCategory2_Success() throws DaoException {
        addCategory_addNewCategory_Success();

        var res = repo.findByName("TestProduct");
        res.setType(null);

        var response = dao.update((CategoryDto) MappingHelper.entityDtoTransformation(res));

        Assertions.assertEquals(200, response.getStatus());
    }
}
