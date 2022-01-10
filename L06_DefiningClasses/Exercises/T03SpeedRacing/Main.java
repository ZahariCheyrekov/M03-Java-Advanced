package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T03SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            double fuelAmount = Double.parseDouble(data[1]);
            double costKilometer = Double.parseDouble(data[2]);

            Car car = new Car(model, fuelAmount, costKilometer);
            cars.put(model, car);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String model = data[1];
            int amountOfKilometers = Integer.parseInt(data[2]);

            cars.get(model).setAmountOfKilometers(amountOfKilometers);
            if (cars.get(model).canDrive()) {
                double currentFuel = cars.get(model).getFuelAmount();
                double amountAfterDriving = Math.abs(currentFuel - cars.get(model).getCostForKilometer() * amountOfKilometers);
                cars.get(model).setFuelAmount(amountAfterDriving);

                int currentDistance = cars.get(model).getTraveledDistance();
                cars.get(model).setTraveledDistance(currentDistance + amountOfKilometers);

            } else {
                System.out.println("Insufficient fuel for the drive");
            }
            input = scanner.nextLine();
        }

        cars.values().forEach(value -> System.out.println(value.toString()));
    }
}