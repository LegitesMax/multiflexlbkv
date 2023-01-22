package at.multiflex.Dao;

import at.multiflex.dao.ColorDao;
import at.multiflex.dao.ColorDao;
import at.multiflex.dao.DaoException;
import at.multiflex.dto.ColorDto;
import at.multiflex.dto.logic.Type;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.repository.ColorRepository;
import at.multiflex.repository.ColorRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class ColorDaoTest {
    @Inject
    ColorDao dao;
    @Inject
    ColorRepository repo;

    @Test
    public void getAllTest() {
        dao.getAll();
    }
    @Test
    public void getByNameTest() {
        addColor_addNewColor_Success();
        dao.getByName("Bambus");
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
    public void addColor_giveNull_throwsIllegalArgumentException() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.add(null);
        });
    }
    @Test
    @TestTransaction
    public void addColor_addNewColor_Success(){
        var entity = new ColorDto();
        entity.setName("TestColor");
        entity.setColorCode("TEST");
        var response = dao.add(entity);

        Assertions.assertEquals(201, response.getStatus());
    }
    @Test
    @TestTransaction
    public void deleteColor_giveNull_throwsIllegalArgumentException() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.delete(null);
        });
    }
    @Test
    @TestTransaction
    public void deleteColor_deleteOneColor_Success() throws DaoException {
        addColor_addNewColor_Success();

        var res = repo.findByName("TestColor");

        var response = dao.delete(res.getId());

        Assertions.assertEquals(204, response.getStatus());
    }
    @Test
    @TestTransaction
    public void updateColorByName_giveNull_throwsIllegalArgumentException() throws DaoException {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.updateByName(null);
        });
    }
    @Test
    @TestTransaction
    public void updateColorByName_updateOneColor_Success() throws DaoException {
        addColor_addNewColor_Success();

        var res = (ColorDto) MappingHelper.entityDtoTransformation(repo.findByName("TestColor"));

        var response = dao.updateByName(res);

        Assertions.assertEquals(200, response.getStatus());
    }
    @Test
    @TestTransaction
    public void updateColorByName_updateOneColor2_Success() throws DaoException {
        addColor_addNewColor_Success();

        var res = (ColorDto) MappingHelper.entityDtoTransformation(repo.findByName("TestColor"));

        res.setColorCode(null);

        var response = dao.updateByName(res);

        Assertions.assertEquals(200, response.getStatus());
    }
    @Test
    @TestTransaction
    public void updateColorById_giveNull_throwsIllegalArgumentException() throws DaoException {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            dao.update(null);
        });
    }
    @Test
    @TestTransaction
    public void updateColorById_updateOneColor_Success() throws DaoException {
        addColor_addNewColor_Success();

        var res = (ColorDto) MappingHelper.entityDtoTransformation(repo.findByName("TestColor"));

        res.setName(null);
        res.setColorCode(null);

        var response = dao.update(res);

        Assertions.assertEquals(200, response.getStatus());
    }
    @Test
    @TestTransaction
    public void updateColorById_updateOneColor2_Success() throws DaoException {
        addColor_addNewColor_Success();

        var res = (ColorDto) MappingHelper.entityDtoTransformation(repo.findByName("TestColor"));

        var response = dao.update(res);

        Assertions.assertEquals(200, response.getStatus());
    }
}
