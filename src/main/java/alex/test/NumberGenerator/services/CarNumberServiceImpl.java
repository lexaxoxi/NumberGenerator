package alex.test.NumberGenerator.services;

import alex.test.NumberGenerator.model.CarNumber;
import alex.test.NumberGenerator.repo.CarNumberRepo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class CarNumberServiceImpl  implements CarNumberService {
    private final CarNumberRepo carNumberRepo;

    public CarNumberServiceImpl(CarNumberRepo carNumberRepo) {
        this.carNumberRepo = carNumberRepo;
    }

    @Override
    public CarNumber findCarNumber(char firstChar, int number, char secondChar, char lastChar) {
        return carNumberRepo.findCarNumber(firstChar, number, secondChar, lastChar);
    }

    @Override
    public CarNumber findCarNumberWithMaxCount() {
        List<CarNumber> carNumbers = carNumberRepo.findCarNumberWithMaxCount();
        return ObjectUtils.isEmpty(carNumbers) ? null : carNumbers.get(0);
    }

    @Override
    public int maxCount() {
        return carNumberRepo.maxCount();
    }

    @Override
    public int amount() {
        return carNumberRepo.amount();
    }

    @Override
    public boolean existsCarNumber(char firstChar, int number, char secondChar, char lastChar) {
        return carNumberRepo.existsCarNumber(firstChar, number, secondChar, lastChar);
    }

    @Override
    public synchronized boolean save(CarNumber carNumber) {
        if (existsCarNumber(carNumber.getFirstChar(),
                carNumber.getNumber(),
                carNumber.getSecondChar(),
                carNumber.getThirdChar())) {
            return false;
        } else {
            carNumberRepo.saveAndFlush(carNumber);
            return true;
        }
    }

    @Override
    public synchronized void update(CarNumber carNumber) {
        carNumberRepo.saveAndFlush(carNumber);
    }

    @Override
    public List<CarNumber> findAll() {
        return carNumberRepo.findAll();
    }
}
