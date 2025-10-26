package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Round;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarGameServiceTest {

    private CarGameService service;

    @BeforeEach
    void setUp() {
        service = new CarGameService();
    }

    @Test
    @DisplayName("입력된 문자열로 자동차 리스트가 생성된다")
    void setUpCars_success() {
        List<Car> cars = service.setUpCars("pobi,woni,jun");
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("라운드 횟수를 문자열로 입력하면 정수로 변환된다")
    void setUpRoundTimes_success() {
        int times = service.setUpRoundTimes("5");
        assertThat(times).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차가 전진하면 position이 증가한다")
    void startRound_moveCarsForward() {
        List<Car> cars = service.setUpCars("pobi,woni");
        Round round = service.startRound(cars, 1);

        List<Car> movedCars = round.getCars();
        assertThat(movedCars).hasSize(2);
        assertThat(movedCars.get(0).getPosition()).isBetween(0, 1);
    }

    @Test
    @DisplayName("최종 라운드에서 우승자를 찾을 수 있다")
    void finalResult_findWinnerCars() {
        List<Car> cars = service.addParticipatingCar(List.of("pobi", "woni"));

        cars.get(0).goForward(9);
        cars.get(1).goForward(3);
        Round round1 = new Round(cars, 1);

        cars.get(0).goForward(5);
        cars.get(1).goForward(5);
        Round round2 = new Round(cars, 2);

        List<Round> rounds = List.of(round1, round2);

        List<String> winners = service.finalResult(rounds);
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    @DisplayName("랜덤값은 0~9 범위에 포함되어야 한다")
    void getRandomValue_inRange() {
        int random = service.getRandomValue();
        assertThat(random).isBetween(0, 9);
    }
}
