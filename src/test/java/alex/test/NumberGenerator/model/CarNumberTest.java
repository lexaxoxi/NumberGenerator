package alex.test.NumberGenerator.model;

import java.util.List;

public class CarNumberTest {
    public static CarNumber testFirstCarNumber() {
        return CarNumber.builder()
                .count(1)
                .firstChar('A')
                .number(999)
                .secondChar('X')
                .thirdChar('X')
                .build();
    }

    public static CarNumber testSecondCarNumber() {
        return CarNumber.builder()
                .count(2)
                .firstChar('B')
                .number(1)
                .secondChar('X')
                .thirdChar('X')
                .build();
    }

    public static List<CarNumber> testListCarNumber() {
        return List.of(testFirstCarNumber(), testSecondCarNumber());
    }
}

