package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T05CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String carInfo() {
        return String.format("%s:%n" +
                "%s%n" +
                "Weight: %s%n" +
                "Color: %s", model, engine.engineInfo(), weight, color);
    }
}