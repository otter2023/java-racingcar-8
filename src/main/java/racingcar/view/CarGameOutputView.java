package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Round;

import java.util.List;

public class CarGameOutputView {

    public void interimResult(Round thisRound) {
        System.out.println("실행 결과");
        List<Car> cars = thisRound.getCars();

        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void finalResult(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }

    public void result(List<Round> rounds, List<String> winners) {
        for (Round round : rounds) {
            interimResult(round);
        }

        finalResult(winners);
    }

}
