package M03_JavaAdvanced.ExamPreparation.Exam20Feb2021.T03CarDealership;


import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getName() {
        return this.name;
    }

    public void add(Car car) {
        if (this.getCapacity() > this.getCount()) {
            this.data.add(car);
        }
    }

    public Car getCar(String manufacturer, String model) {
        return this.data
                .stream()
                .filter(car -> car.getManufacturer().equals(manufacturer) &&
                        car.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public Car getLatestCar() {
        int oldestYear = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getYear() >= oldestYear) {
                index = i;
                oldestYear = this.data.get(i).getYear();
            }
        }
        return this.data.get(index);
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }

        return false;
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder();

        out.append(String.format("The cars are in a car dealership %s:%n", this.getName()));


        for (Car value : this.data) {
            out.append(value.toString())
                    .append(System.lineSeparator());
        }
        return out.toString();
    }
}