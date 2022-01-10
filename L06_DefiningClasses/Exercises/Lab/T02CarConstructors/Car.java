package M03_JavaAdvanced.L06_DefiningClasses.Lab.T02CarConstructors;

public class Car {
    private String brand;
    private String model;
    private int horsePowers;

    public Car(String brand, String model, int horsePowers) {
        this(brand);
        this.model = model;
        this.horsePowers = horsePowers;
    }

    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsePowers = -1;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePowers() {
        return horsePowers;
    }

    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.",
                getBrand(), getModel(), getHorsePowers());
    }
}
