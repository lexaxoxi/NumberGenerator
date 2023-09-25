package alex.test.NumberGenerator.repos;

import alex.test.NumberGenerator.model.CarNumber;
import alex.test.NumberGenerator.repo.CarNumberRepo;
import alex.test.NumberGenerator.model.CarNumberTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static alex.test.NumberGenerator.model.CarNumberTest.testFirstCarNumber;
import static alex.test.NumberGenerator.model.CarNumberTest.testSecondCarNumber;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarNumberRepoTest {
    @Autowired
    private CarNumberRepo carNumberRepoH2;

    @Test
    void testFindCarNumber() {
        carNumberRepoH2.saveAndFlush(testFirstCarNumber());
        CarNumber actualСarNumber = carNumberRepoH2.findCarNumber(testFirstCarNumber().getFirstChar(),
                testFirstCarNumber().getNumber(),
                testFirstCarNumber().getSecondChar(),
                testFirstCarNumber().getThirdChar());
        Assertions.assertEquals(actualСarNumber, testFirstCarNumber());
    }

    @Test
    void testFindCarNumberWithMaxCount() {
        carNumberRepoH2.saveAndFlush(testFirstCarNumber());
        carNumberRepoH2.saveAndFlush(testSecondCarNumber());
        CarNumber actualСarNumber = carNumberRepoH2.findCarNumberWithMaxCount().get(0);
        Assertions.assertEquals(actualСarNumber, testSecondCarNumber());
    }

    @Test
    void testMaxCount() {
        carNumberRepoH2.saveAndFlush(testFirstCarNumber());
        int maxCount = carNumberRepoH2.maxCount();
        Assertions.assertEquals(maxCount, 1);
        carNumberRepoH2.saveAndFlush(testSecondCarNumber());
        maxCount = carNumberRepoH2.maxCount();
        Assertions.assertEquals(maxCount, 2);
    }

    @Test
    void testAmount() {
        int amount = carNumberRepoH2.amount();
        Assertions.assertEquals(amount, 0);
        carNumberRepoH2.saveAndFlush(testFirstCarNumber());
        carNumberRepoH2.saveAndFlush(testSecondCarNumber());
        amount = carNumberRepoH2.amount();
        Assertions.assertEquals(amount, 2);
    }
}
