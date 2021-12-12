package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T03SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double costForKilometer;
    private int traveledDistance = 0;
    private int amountOfKilometers;

    public Car(String model, double fuelAmount, double costForKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.costForKilometer = costForKilometer;
    }

    public String getModel() {
        return model;
    }

    public int getTraveledDistance() {
        return traveledDistance;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getCostForKilometer() {
        return costForKilometer;
    }

    public void setAmountOfKilometers(int amountOfKilometers) {
        this.amountOfKilometers = amountOfKilometers;
    }

    public void setTraveledDistance(int traveledDistance) {
        this.traveledDistance = traveledDistance;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    boolean canDrive() {
        return fuelAmount >= costForKilometer * amountOfKilometers;
    }

    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, traveledDistance);
    }
}