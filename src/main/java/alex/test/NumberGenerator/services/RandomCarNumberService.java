package alex.test.NumberGenerator.services;

import alex.test.NumberGenerator.exception.CarNumbersOverflow;
import alex.test.NumberGenerator.model.CarNumber;
import alex.test.NumberGenerator.utils.RandomCarNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RandomCarNumberService {
    private final CarNumberService carNumberService;

    public RandomCarNumberService(CarNumberService carNumberService) {
        this.carNumberService = carNumberService;
    }

    public CarNumber randomCarNumber() {

        if (carNumberService.amount() == 12 * 10 * 10 * 10 * 12 * 12) {
            throw new CarNumbersOverflow();
        }

        CarNumber carNumber = null;
        do {
            carNumber = RandomCarNumber.carNumberRandom();
        } while (!carNumberService.save(carNumber));

        return carNumber;
    }

}
