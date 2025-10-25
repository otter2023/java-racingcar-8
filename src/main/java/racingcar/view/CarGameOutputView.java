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

    public void finalResult(Round result) {
        System.out.print("최종 우승자 : ");
        System.out.println(result);
    }

    public void result(List<Round> rounds) {
        for (Round round : rounds) {
            interimResult(round);
        }

        Round finalRound = rounds.getLast(); // Java 21+ 에만 존재
        finalResult(finalRound);
    }

}
