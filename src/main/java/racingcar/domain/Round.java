package racingcar.domain;

import java.util.List;

public class Round {
    List<Car> cars;
    int roundNumber;

    public Round() {
    }

    public Round(List<Car> cars, int roundNumber) {
        this.cars = cars;
        this.roundNumber = roundNumber;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}
