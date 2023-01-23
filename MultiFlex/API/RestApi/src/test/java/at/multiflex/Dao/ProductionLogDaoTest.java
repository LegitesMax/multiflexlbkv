package at.multiflex.Dao;

import at.multiflex.dao.ProductionLogDao;
import at.multiflex.dao.DaoException;
import at.multiflex.dto.ColorDto;
import at.multiflex.dto.ProductionLogDto;
import at.multiflex.dto.logic.Production;
import at.multiflex.dto.wares.ProductDto;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.repository.ColorRepository;
import at.multiflex.repository.wares.ProductRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class ProductionLogDaoTest {
    @Inject
    ProductionLogDao dao;
    @Inject
    ProductRepository repo;

    @Test
    public void getAllTest() {
        dao.getAll();
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
    public void deleteProduction_giveNull_throwsIllegalArgumentException() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.delete(null);
        });
    }
    @Test
    @TestTransaction
    public void deleteProduction_deleteOneProduction_Success() throws DaoException {
        var response = dao.delete(1);

        Assertions.assertEquals(204, response.getStatus());
    }
    @Test
    @TestTransaction
    public void updateProductionProduce_giveNull_throwsIllegalArgumentException()  {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.produce(null);
        });
    }
    @Test
    @TestTransaction
    public void updateProductionProduce_updateOneColor_Success()  {
        var prod = new Production();
        prod.setProduct((ProductDto) MappingHelper.entityDtoTransformation(repo.findById(1)));
        dao.produce(prod);
    }
    @Test
    @TestTransaction
    public void updateProductionConsume_updateOneColor2_Success()  {
        var prod = new Production();
        prod.setProduct((ProductDto) MappingHelper.entityDtoTransformation(repo.findById(1)));

        var response = dao.consume(prod);

        Assertions.assertEquals(201, response.getStatus());
    }
    @Test
    @TestTransaction
    public void updateProductionConsume_giveNull_throwsIllegalArgumentException()  {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.consume(null);
        });
    }
    @Test
    @TestTransaction
    public void updateProductionFixStock_giveNull_throwsIllegalArgumentException()  {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.fixStock(null);
        });
    }
    @Test
    @TestTransaction
    public void updateProductionFixStock_updateOneProduct_Success()  {
        var prod = new Production();
        prod.setProduct((ProductDto) MappingHelper.entityDtoTransformation(repo.findById(1)));

        var response = dao.fixStock(prod);

        Assertions.assertEquals(201, response.getStatus());
    }
}
