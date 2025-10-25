package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Round;
import racingcar.utils.Parser;

import java.util.ArrayList;
import java.util.List;

public class CarGameService {

    private final Parser parser;

    public CarGameService(Parser parser) {
        this.parser = parser;
    }

    public List<Round> carGameStart(String carsLineUp, Integer times) {

        List<Car> cars = setUpCars(carsLineUp);
        List<Round> gameRounds = new ArrayList<>();

        for (int i = 1; i <= times; i++) {
            Round round = startRound(cars, i);
            gameRounds.add(round);
        }

        return gameRounds;
    }

    public Round startRound(List<Car> cars, Integer roundNumber) {

        Round round = new Round(cars, roundNumber);

        // TODO : 게임 진행


        return round;
    }

    public List<Car> setUpCars(String carsLineUp) {
        List<String> carNames = parser.splitCars(carsLineUp);
        return addParticipatingCar(carNames);
    }

    public List<Car> addParticipatingCar(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

}
