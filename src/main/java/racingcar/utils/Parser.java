package racingcar.utils;

import java.util.List;
import java.util.regex.Pattern;

public class Parser {

    private static final String delimiter = ",";

    public List<String> splitCars(String carsLineUp) {
        return List.of(carsLineUp.split(Pattern.quote(delimiter)));
    }
}
