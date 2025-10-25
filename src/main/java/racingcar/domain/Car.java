package racingcar.domain;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.position = 0;
        this.name = name;
    }

    public Car(Car other) {
        this.name = other.name;
        this.position = other.position;
    }

    public Car copy() {
        return new Car(this);
    }


    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
