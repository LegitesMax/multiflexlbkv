package at.multiflex.Dao.others;

import at.multiflex.dao.others.HashDao;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class HashDaoTest {
    @Inject
    HashDao hashDao;

    @Test
    @TestTransaction
    public void getAll(){
        hashDao.getAll();
    }
}
