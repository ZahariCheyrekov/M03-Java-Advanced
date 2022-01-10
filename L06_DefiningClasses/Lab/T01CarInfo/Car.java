package M03_JavaAdvanced.L06_DefiningClasses.Lab.T01CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsePowers;

    public Car(String brand, String model, int horsePowers) {
        this.brand = brand;
        this.model = model;
        this.horsePowers = horsePowers;
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

    public void carInfo() {
        System.out.printf("The car is: %s %s - %d HP.%n",
                getBrand(), getModel(), getHorsePowers());
    }
}