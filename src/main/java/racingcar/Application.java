package racingcar;

import racingcar.controller.CarGameController;
import racingcar.service.CarGameService;
import racingcar.utils.Parser;
import racingcar.view.CarGameInputView;
import racingcar.view.CarGameOutputView;

public class Application {
    public static void main(String[] args) {
        Parser parser = new Parser();

        CarGameInputView inputView = new CarGameInputView();
        CarGameOutputView outputView = new CarGameOutputView();
        CarGameService service = new CarGameService(parser);
        CarGameController controller = new CarGameController(inputView, outputView, service);

        controller.run();
    }
}
