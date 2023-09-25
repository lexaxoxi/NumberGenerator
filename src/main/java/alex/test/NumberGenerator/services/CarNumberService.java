package alex.test.NumberGenerator.services;

import alex.test.NumberGenerator.model.CarNumber;

import java.util.List;

public interface CarNumberService {

    CarNumber findCarNumber(char firstChar, int number, char secondChar, char thirdChar);

    CarNumber findCarNumberWithMaxCount();

    int maxCount();

    int amount();

    boolean existsCarNumber(char firstChar, int number, char secondChar, char thirdChar);

    boolean save(CarNumber carNumber);

    void update(CarNumber carNumber);

    List<CarNumber> findAll();
}
