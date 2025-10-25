package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

// Round의 결과를 저장
public class Round {
    List<Car> cars;
    int roundNumber;

    public Round() {
    }

    public Round(List<Car> cars, int roundNumber) {
        this.cars = cars.stream()
                .map(Car::copy)
                .collect(Collectors.toList());
        this.roundNumber = roundNumber;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}
