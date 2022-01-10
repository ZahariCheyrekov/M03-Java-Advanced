package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T07Google;

public class Car {
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public String carInfo() {
        return model + " " + speed;
    }
}