package alex.test.NumberGenerator.utils;

import alex.test.NumberGenerator.model.CarNumber;
import lombok.experimental.UtilityClass;

import java.util.concurrent.ThreadLocalRandom;
import static alex.test.NumberGenerator.utils.Chars.*;

@UtilityClass
public class RandomCarNumber {
    public CarNumber carNumberRandom() {
        return CarNumber.builder()
                .firstChar(charRandom())
                .number(numberRandom())
                .secondChar(charRandom())
                .thirdChar(charRandom())
                .build();
    }

    private char charRandom() {
        return getCharFromCharsByIndex(ThreadLocalRandom.current()
                .nextInt(getCharsSize()));
    }

    private int numberRandom() {
        return ThreadLocalRandom.current()
                .nextInt(1000);
    }
}
