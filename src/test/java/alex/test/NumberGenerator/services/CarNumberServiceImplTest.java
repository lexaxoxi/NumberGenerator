package alex.test.NumberGenerator.services;

import alex.test.NumberGenerator.model.CarNumber;
import alex.test.NumberGenerator.repo.CarNumberRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static alex.test.NumberGenerator.model.CarNumberTest.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarNumberServiceImplTest {
    private CarNumberRepo carNumberRepository;
    private CarNumberService carNumberService;

    @BeforeEach
    void setUp() {
        carNumberRepository = mock(CarNumberRepo.class);
        carNumberService = new CarNumberServiceImpl(carNumberRepository);
    }

    @Test
    void testFindCarNumber() {
        when(carNumberRepository.findCarNumber(testFirstCarNumber().getFirstChar(),
                testFirstCarNumber().getNumber(),
                testFirstCarNumber().getSecondChar(),
                testFirstCarNumber().getThirdChar()))
                .thenReturn(testFirstCarNumber());
        CarNumber carNumber = carNumberService.findCarNumber(testFirstCarNumber().getFirstChar(),
                testFirstCarNumber().getNumber(),
                testFirstCarNumber().getSecondChar(),
                testFirstCarNumber().getThirdChar());
        Assertions.assertEquals(carNumber, testFirstCarNumber());
    }

    @Test
    void testFindCarNumberWithMaxCount() {
        when(carNumberRepository.findCarNumberWithMaxCount()).thenReturn(List.of(testFirstCarNumber()));
        CarNumber carNumber = carNumberService.findCarNumberWithMaxCount();
        Assertions.assertEquals(carNumber, testFirstCarNumber());
    }

    @Test
    void testMaxCount() {
        when(carNumberRepository.maxCount()).thenReturn(1);
        int maxCount = carNumberService.maxCount();
        Assertions.assertEquals(maxCount, 1);
    }

    @Test
    void testAmount() {
        when(carNumberRepository.amount()).thenReturn(0);
        int amount = carNumberService.amount();
        Assertions.assertEquals(amount, 0);
    }

    @Test
    void testSave() {
        when(carNumberRepository.saveAndFlush(any())).thenReturn(testFirstCarNumber());
        carNumberService.save(testFirstCarNumber());
        Assertions.assertNotNull(testFirstCarNumber());
    }

    @Test
    void testUpdate() {
        when(carNumberRepository.saveAndFlush(any())).thenReturn(testFirstCarNumber());
        carNumberService.update(testFirstCarNumber());
        Assertions.assertNotNull(testFirstCarNumber());
    }

    @Test
    void testFindAll() {
        when(carNumberRepository.findAll()).thenReturn(testListCarNumber());
        List<CarNumber> carNumbers = carNumberService.findAll();
        Assertions.assertNotNull(carNumbers);
        Assertions.assertEquals(carNumbers, testListCarNumber());
    }
}
