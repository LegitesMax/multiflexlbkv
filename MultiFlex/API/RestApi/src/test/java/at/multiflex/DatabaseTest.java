package at.multiflex;

import at.multiflex.dao.*;
import at.multiflex.dao.wares.ArticleDao;
import at.multiflex.dao.wares.MaterialDao;
import at.multiflex.dao.wares.ProductDao;
import at.multiflex.dto.CategoryDto;
import at.multiflex.dto.ColorDto;
import at.multiflex.dto.SizeDto;
import at.multiflex.dto.logic.Type;
import at.multiflex.dto.wares.MaterialDto;
import at.multiflex.dto.wares.ProductDto;
import at.multiflex.repository.CategoryRepository;
import at.multiflex.repository.ColorRepository;
import at.multiflex.repository.SizeRepository;
import at.multiflex.repository.wares.ArticleRepository;
import at.multiflex.repository.wares.MaterialRepository;
import at.multiflex.repository.wares.ProductRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

@QuarkusTest
class DatabaseTest {
    //region Injects
    @Inject
    ArticleDao articleDao;
    @Inject
    MaterialDao materialDao;
    @Inject
    ProductDao productDao;
    @Inject
    CategoryDao categoryDao;
    @Inject
    ColorDao colorDao;
    @Inject
    ProductionLogDao productionLogDao;
    @Inject
    SizeDao sizeDao;
    @Inject
    ArticleRepository articleRepo;
    @Inject
    ProductRepository productRepo;
    @Inject
    MaterialRepository materialRepo;
    @Inject
    CategoryRepository categoryRepo;
    @Inject
    SizeRepository sizeRepo;
    @Inject
    ColorRepository colorRepo;
    //endregion
    //region Add
    @Test
    @TestTransaction
    public void addCategory_addOneProductAndOneMaterialCategory_Success() {
        var category = new CategoryDto();
        category.setAcronym("TESTM");
        category.setName("TestMaterial");
        category.setType(Type.Material);

        var category2 = new CategoryDto();
        category2.setAcronym("TESTP");
        category2.setName("TestProduct");
        category2.setType(Type.Product);

        var response = categoryDao.add(category);
        var response2 = categoryDao.add(category2);

        Assertions.assertEquals(201, response.getStatus());
        Assertions.assertEquals(201, response2.getStatus());
    }
    @Test
    @TestTransaction
    public void addMaterial_addNewMaterial_Success() {
        var category = new CategoryDto();
        category.setAcronym("TESTM");
        category.setName("TestMaterial");
        category.setType(Type.Product);
        var response = categoryDao.add(category);

        var material = new MaterialDto();
        material.setName("TestMaterial");
        material.setValue(1.0);
        material.setMinValue(2.0);

        var response2 = materialDao.add(material);

        Assertions.assertEquals(201, response.getStatus());
        Assertions.assertEquals(201, response2.getStatus());
    }

    @Test
    @TestTransaction
    public void addProduct_addNewProduct_Success() {
        var category = new CategoryDto();
        category.setAcronym("TESTP");
        category.setName("TestProduct");
        category.setType(Type.Product);
        var response = categoryDao.add(category);

        var product = new ProductDto();
        product.setName("TESTP 39 BA");
        product.setValue(1.0);
        product.setMinValue(2.0);

        var response2 = productDao.add(product);

        Assertions.assertEquals(201, response.getStatus());
        Assertions.assertEquals(201, response2.getStatus());
    }
    @Test
    @TestTransaction
    public void addSize_addNewSize_Success() {
        var entity = new SizeDto();

        entity.setSize(50);
        entity.setDescription("Testdesc");

        var response = sizeDao.add(entity);

        Assertions.assertEquals(201, response.getStatus());
    }

    @Test
    @TestTransaction
    public void addColor_addNewColor_Success() {
        var entity = new ColorDto();

        entity.setName("Test");
        entity.setColorCode("TEST");

        var response = colorDao.add(entity);

        Assertions.assertEquals(201, response.getStatus());
    }
    //endregion
    //region Select
    @Test
    @TestTransaction
    public void findCategory_findCategoryByName_Success() {
        addCategory_addOneProductAndOneMaterialCategory_Success();

        var res = categoryRepo.findByName("TestMaterial");

        Assertions.assertEquals("TestMaterial", res.getName());
    }
    @Test
    @TestTransaction
    public void findCategory_findCategoryByAcronym_Success() {
        addCategory_addOneProductAndOneMaterialCategory_Success();

        var res = categoryRepo.findByAcronym("TESTM");

        Assertions.assertEquals("TESTM", res.getAcronym());
    }
    @Test
    @TestTransaction
    public void findMaterial_findMaterialByName_Success() {
        addMaterial_addNewMaterial_Success();

        var res = materialRepo.findByName("TestMaterial");

        Assertions.assertEquals("TestMaterial", res.get(0).getName());
    }
    @Test
    @TestTransaction
    public void findProduct_findProductByName_Success() {
        addProduct_addNewProduct_Success();

        var res = productRepo.findByName("TESTP 39 BA");

        Assertions.assertEquals("TESTP 39 BA", res.get(0).getName());
    }
    @Test
    @TestTransaction
    public void findSize_findSize_Success() {
        addSize_addNewSize_Success();

        var res = sizeRepo.findBySize(50);

        Assertions.assertEquals(50, res.getSize());
    }
    @Test
    @TestTransaction
    public void findColor_findColorByName_Success() {
        addColor_addNewColor_Success();

        var res = colorRepo.findByName("Test");

        Assertions.assertEquals("Test", res.getName());
    }
    @Test
    @TestTransaction
    public void findColor_findColorByColorCode_Success() {
        addColor_addNewColor_Success();

        var res = colorRepo.findByColorCode("TEST");

        Assertions.assertEquals("TEST", res.getColorCode());
    }
    //endregion
    //region Delete
    @Test
    @TestTransaction
    public void deleteCategory_deleteOneProductAndOneMaterialCategory_Success() throws DaoException {
        addCategory_addOneProductAndOneMaterialCategory_Success();

        var res = categoryRepo.findByAcronym("TESTM");
        var res2 = categoryRepo.findByAcronym("TESTP");

        var response = categoryDao.delete(res.getId());
        var response2 = categoryDao.delete(res2.getId());

        Assertions.assertEquals(204, response.getStatus());
        Assertions.assertEquals(204, response2.getStatus());
    }
    @Test
    @TestTransaction
    public void deleteProduct_deleteOneProduct_Success() throws DaoException {
        addProduct_addNewProduct_Success();

        var res = productRepo.findByName("TESTP 39 BA");

        var response = productDao.delete(res.get(0).getId());

        Assertions.assertEquals(204, response.getStatus());
    }
    @Test
    @TestTransaction
    public void deleteSize_deleteOneSize_Success() throws DaoException {
        addSize_addNewSize_Success();

        var res = sizeRepo.findBySize(50);

        var response = sizeDao.delete(res.getId());

        Assertions.assertEquals(204, response.getStatus());
    }
    @Test
    @TestTransaction
    public void deleteColor_deleteOneColor_Success() throws DaoException {
        addColor_addNewColor_Success();

        var res = colorRepo.findByName("Test");

        var response = colorDao.delete(res.getId());

        Assertions.assertEquals(204, response.getStatus());
    }
    //endregion

}