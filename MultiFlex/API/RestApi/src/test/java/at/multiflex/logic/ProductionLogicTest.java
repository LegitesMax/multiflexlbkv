package at.multiflex.logic;

import at.multiflex.Logic.ProductionLogic;
import at.multiflex.dao.CategoryDao;
import at.multiflex.dao.DaoException;
import at.multiflex.dao.wares.ProductDao;
import at.multiflex.dto.CategoryDto;
import at.multiflex.dto.logic.Type;
import at.multiflex.dto.wares.ProductDto;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.model.Wares.Article;
import at.multiflex.model.Wares.Product;
import at.multiflex.repository.wares.ProductRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class ProductionLogicTest {
    @Inject
    ProductDao dao;
    @Inject
    ProductRepository repo;
    @Inject
    CategoryDao categoryDao;
    @Inject
    ProductionLogic logic;
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
    public void produce_produceAProduct_Success() {
        var entity = (Product) MappingHelper.entityDtoTransformation((ProductDto) dao.getById(1));
        logic.produce(entity);
    }
    @Test
    @TestTransaction
    public void consume_consumeAProduct_Success() {
        var entity = (Product) MappingHelper.entityDtoTransformation((ProductDto) dao.getById(1));
        logic.consume(entity);
    }
    @Test
    @TestTransaction
    public void fixStock_fixAProductStock_Success() {
        var entity = (Product) MappingHelper.entityDtoTransformation((ProductDto) dao.getById(1));
        logic.fixStock(entity, 1.0);
    }
}
