package at.multiflex;

import at.multiflex.dao.*;
import at.multiflex.dao.wares.ArticleDao;
import at.multiflex.dao.wares.MaterialDao;
import at.multiflex.dao.wares.ProductDao;
import at.multiflex.dto.SizeDto;
import at.multiflex.dto.wares.MaterialDto;
import at.multiflex.model.Wares.Material;
import at.multiflex.repository.CRUDOperations;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
class DatabaseTest {
    @Inject
    CRUDOperations crud;
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
    public void addMaterial() throws DaoException {
        var material = new MaterialDto();
        material.setName("TestMaterial 39 BA");
        material.setValue(1.0);
        material.setMinValue(2.0);

        var response = materialDao.add(material);

        //System.out.println(response);
        //Assertions.assertEquals(material, m);
    }
    @Test
    @TestTransaction
    public void addSize() throws DaoException {
        var entity = new SizeDto();

        entity.setSize(50);
        entity.setDescription("Testdesc");

        var response = sizeDao.add(entity);

        System.out.println(response);
        //Assertions.assertEquals(material, m);
    }
}
