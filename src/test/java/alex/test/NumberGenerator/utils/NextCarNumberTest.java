package alex.test.NumberGenerator.utils;

import alex.test.NumberGenerator.exception.CarNumbersOverflow;
import alex.test.NumberGenerator.model.CarNumber;
import org.junit.jupiter.api.Test;

import static alex.test.NumberGenerator.model.CarNumberTest.testFirstCarNumber;
import static alex.test.NumberGenerator.model.CarNumberTest.testSecondCarNumber;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextCarNumberTest {
    @Test
    void testNextCarNumber() throws CarNumbersOverflow {
        CarNumber actualCarNumber = NextCarNumber.nextCarNumber(testFirstCarNumber());
        assertNotNull(actualCarNumber);
        assertNotEquals(testFirstCarNumber(), actualCarNumber);
        assertEquals(testSecondCarNumber(), actualCarNumber);
    }

    @Test
    void testComplexCarNumber() {
        assertEquals(NextCarNumber.nextCarNumber(CarNumber.builder()
                        .firstChar('A')
                        .number(1)
                        .secondChar('A')
                        .thirdChar('A')
                        .build()),
                CarNumber.builder().
                        firstChar('A')
                        .number(2)
                        .secondChar('A')
                        .thirdChar('A')
                        .build());

        assertEquals(NextCarNumber.nextCarNumber(CarNumber.builder()
                        .firstChar('A')
                        .number(999)
                        .secondChar('A')
                        .thirdChar('A')
                        .build()),
                CarNumber.builder().
                        firstChar('A')
                        .number(1)
                        .secondChar('A')
                        .thirdChar('B')
                        .build());

        assertEquals(NextCarNumber.nextCarNumber(CarNumber.builder()
                        .firstChar('A')
                        .number(999)
                        .secondChar('A')
                        .thirdChar('X')
                        .build()),
                CarNumber.builder().
                        firstChar('A')
                        .number(1)
                        .secondChar('B')
                        .thirdChar('X')
                        .build());

        assertEquals(NextCarNumber.nextCarNumber(CarNumber.builder()
                        .firstChar('A')
                        .number(998)
                        .secondChar('B')
                        .thirdChar('X')
                        .build()),
                CarNumber.builder().
                        firstChar('A')
                        .number(999)
                        .secondChar('B')
                        .thirdChar('X')
                        .build());

        assertEquals(NextCarNumber.nextCarNumber(CarNumber.builder()
                        .firstChar('A')
                        .number(999)
                        .secondChar('X')
                        .thirdChar('X')
                        .build()),
                CarNumber.builder().
                        firstChar('B')
                        .number(1)
                        .secondChar('X')
                        .thirdChar('X')
                        .build());

        assertEquals(NextCarNumber.nextCarNumber(CarNumber.builder()
                        .firstChar('A')
                        .number(1)
                        .secondChar('X')
                        .thirdChar('X')
                        .build()),
                CarNumber.builder().
                        firstChar('A')
                        .number(2)
                        .secondChar('X')
                        .thirdChar('X')
                        .build());

        assertEquals(NextCarNumber.nextCarNumber(CarNumber.builder()
                        .firstChar('B')
                        .number(999)
                        .secondChar('X')
                        .thirdChar('X')
                        .build()),
                CarNumber.builder().
                        firstChar('E')
                        .number(1)
                        .secondChar('X')
                        .thirdChar('X')
                        .build());
    }
}
