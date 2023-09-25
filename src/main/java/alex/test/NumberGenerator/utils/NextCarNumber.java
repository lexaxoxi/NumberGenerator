package alex.test.NumberGenerator.utils;

import alex.test.NumberGenerator.exception.CarNumbersOverflow;
import alex.test.NumberGenerator.model.CarNumber;
import lombok.experimental.UtilityClass;

import static alex.test.NumberGenerator.utils.Chars.*;
@UtilityClass
public class NextCarNumber {
    private static int count = 0;

    public static CarNumber nextCarNumber(CarNumber carNumber) {
        char firstChar = carNumber.getFirstChar();
        int numb = carNumber.getNumber();
        char secondChar = carNumber.getSecondChar();
        char thirdChar = carNumber.getThirdChar();

        CarNumber nextCarNumber = CarNumber.builder()
                .count(++count)
                .firstChar(firstChar)
                .number(numb)
                .secondChar(secondChar)
                .thirdChar(thirdChar)
                .build();

        if (numb != 999) {
            nextCarNumber.setNumber(nextNumber(numb));
        } else if (thirdChar != getLastCharFromChars()) {
            nextCarNumber.setNumber(nextNumber(numb));
            nextCarNumber.setThirdChar(nextChar(thirdChar));
        } else if (secondChar != getLastCharFromChars()) {
            nextCarNumber.setNumber(nextNumber(numb));
            nextCarNumber.setSecondChar(nextChar(secondChar));
        } else if (firstChar != getLastCharFromChars()) {
            nextCarNumber.setFirstChar(nextChar(firstChar));
            nextCarNumber.setNumber(nextNumber(numb));
        } else {
            throw new CarNumbersOverflow();
        }
        return nextCarNumber;
    }

    private int nextNumber(int numb) {
        return numb == 999
                ? 1
                : ++numb;
    }

    private char nextChar(char ch) {
        int index = getIndexCharFromCarts(ch);
        return ch == getLastCharFromChars()
                ? ch
                : getCharFromCharsByIndex(++index);
    }

}
