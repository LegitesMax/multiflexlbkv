package at.multiflex.Dao;

import at.multiflex.dao.SizeDao;
import at.multiflex.dao.DaoException;
import at.multiflex.dto.SizeDto;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.repository.SizeRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class SizeDaoTest {
    @Inject
    SizeDao dao;
    @Inject
    SizeRepository repo;

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
    public void addSize_giveNull_throwsIllegalArgumentException() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.add(null);
        });
    }
    @Test
    @TestTransaction
    public void addSize_addNewSize_Success(){
        var entity = new SizeDto();
        entity.setSize(100);
        entity.setDescription("TEST");
        var response = dao.add(entity);

        Assertions.assertEquals(201, response.getStatus());
    }
    @Test
    @TestTransaction
    public void deleteSize_giveNull_throwsIllegalArgumentException() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.delete(null);
        });
    }
    @Test
    @TestTransaction
    public void deleteSize_deleteOneSize_Success() throws DaoException {
        addSize_addNewSize_Success();

        var res = repo.findBySize(100);

        var response = dao.delete(res.getId());

        Assertions.assertEquals(204, response.getStatus());
    }
    @Test
    @TestTransaction
    public void updateSizeByName_giveNull_throwsIllegalArgumentException() throws DaoException {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.updateBySize(null);
        });
    }
    @Test
    @TestTransaction
    public void updateSizeBySize_updateOneSize_Success() throws DaoException {
        addSize_addNewSize_Success();

        var res = (SizeDto) MappingHelper.entityDtoTransformation(repo.findBySize(100));

        var response = dao.updateBySize(res);

        Assertions.assertEquals(200, response.getStatus());
    }
    @Test
    @TestTransaction
    public void updateSizeBySize_updateOneSize2_Success() throws DaoException {
        addSize_addNewSize_Success();

        var res = (SizeDto) MappingHelper.entityDtoTransformation(repo.findBySize(100));

        res.setDescription(null);

        var response = dao.updateBySize(res);

        Assertions.assertEquals(200, response.getStatus());
    }
    @Test
    @TestTransaction
    public void updateSizeById_giveNull_throwsIllegalArgumentException()  {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.update(null);
        });
    }
    @Test
    @TestTransaction
    public void updateSizeById_updateOneSize_Success()  {
        addSize_addNewSize_Success();

        var res = (SizeDto) MappingHelper.entityDtoTransformation(repo.findBySize(100));

        res.setSize(null);
        res.setDescription(null);

        var response = dao.update(res);

        Assertions.assertEquals(200, response.getStatus());
    }
    @Test
    @TestTransaction
    public void updateSizeById_updateOneSize2_Success() throws DaoException {
        addSize_addNewSize_Success();

        var res = (SizeDto) MappingHelper.entityDtoTransformation(repo.findBySize(100));

        var response = dao.update(res);

        Assertions.assertEquals(200, response.getStatus());
    }
}
