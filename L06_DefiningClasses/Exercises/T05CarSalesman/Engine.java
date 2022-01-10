package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T05CarSalesman;

public class Engine {
    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String engineInfo() {
        return String.format("%s:%n" +
                "Power: %s%n" +
                "Displacement: %s%n" +
                "Efficiency: %s", model, power, displacement, efficiency);
    }
}