package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
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
        for (Car car : cars) {
            int value = getRandomValue();
            car.goForward(value);
        }

        return new Round(cars, roundNumber);
    }

    public List<String> finalResult(List<Round> rounds) {
        Round finalRound = rounds.getLast(); // Java 21+에만 존재
        List<Car> cars =  finalRound.getCars();
        int maxPosition = findMaxPosition(cars);

        return findWinnerCars(cars, maxPosition);
    }

    public int findMaxPosition(List<Car> cars){
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<String> findWinnerCars(List<Car> cars, int maxPosition){
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();

        return winners;
    }

    public int getRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
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
