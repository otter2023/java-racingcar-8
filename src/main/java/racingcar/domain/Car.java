package racingcar.domain;

public class Car {

    private String name;
    private int step;

    public Car(String name) {
        this.step = 0;
        this.name = name;
    }

    public int getStep() {
        return step;
    }

    public String getName() {
        return name;
    }
}
