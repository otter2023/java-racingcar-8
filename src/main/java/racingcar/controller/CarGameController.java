package racingcar.controller;

import racingcar.service.CarGameService;
import racingcar.domain.Round;
import racingcar.view.CarGameInputView;
import racingcar.view.CarGameOutputView;

import java.util.List;

public class CarGameController {

    private final CarGameService service;
    private final CarGameInputView inputView;
    private final CarGameOutputView outputView;

    public CarGameController(CarGameInputView inputView, CarGameOutputView outputView, CarGameService service) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String carsLineUp = inputView.inputCarName();
        Integer times = inputView.tryTimes();

        List<Round> rounds = service.carGameStart(carsLineUp, times);

        outputView.result(rounds);
    }
}
