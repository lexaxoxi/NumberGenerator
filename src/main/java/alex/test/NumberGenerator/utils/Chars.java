package alex.test.NumberGenerator.utils;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class Chars {
    private final List<Character> chars = List.of('A', 'B', 'E', 'K', 'M', 'H', 'O', 'P', 'C', 'T', 'Y', 'X');

    int getCharsSize() {
        return chars.size();
    }

    int getIndexCharFromCarts(char ch) {
        return chars.indexOf(ch);
    }

    char getCharFromCharsByIndex(int index) {
        return chars.get(index);
    }

    char getLastCharFromChars() {
        return chars.get(getCharsSize() - 1);
    }

}
