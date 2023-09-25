package alex.test.NumberGenerator.exception;

import org.springframework.core.NestedRuntimeException;

public class CarNumbersOverflow extends NestedRuntimeException {

    private static final String ERROR = "List of cars numbers is overflow";

    public CarNumbersOverflow() {
        super(ERROR);
    }
}
