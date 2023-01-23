package at.multiflex.logic;

import at.multiflex.dto.logic.Production;
import at.multiflex.dto.wares.ProductDto;
import at.multiflex.mapper.MappingHelper;
import at.multiflex.repository.CRUDOperations;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class CRUDTest {
    @Inject
    CRUDOperations crud;

    @Test
    @TestTransaction
    public void addEntity_giveNull_throwsIllegalArgumentException()  {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            crud.add(null);
        });
    }
    @Test
    @TestTransaction
    public void deleteEntity_giveNull_throwsIllegalArgumentException()  {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            crud.delete(null);
        });
    }
}
