package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.data = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return this.data
                .removeIf(car -> car.getManufacturer().equals(manufacturer) &&
                        car.getModel().equals(model));
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

    public Car getCar(String manufacturer, String model) {
        return this.data
                .stream()
                .filter(car -> car.getManufacturer().equals(manufacturer) &&
                        car.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder message = new StringBuilder();

        message.append(String.format(" The cars are in a car dealership %s:", this.name))
                .append(System.lineSeparator());

        for (Car car : this.data) {
            message.append(car)
                    .append(System.lineSeparator());
        }

        return message.toString().trim();
    }
}
