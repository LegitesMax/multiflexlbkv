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
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
class DatabaseTest {
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
}
