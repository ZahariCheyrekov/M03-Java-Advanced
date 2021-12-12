package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T05CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Engine> engines = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            String power = data[1];
            String displacement = "n/a";
            String efficiency = "n/a";

            if (data.length == 3) {
                String current = data[2];

                if (checkForDigits(current)) {
                    displacement = current;
                } else {
                    efficiency = current;
                }
            } else if (data.length == 4) {
                displacement = data[2];
                efficiency = data[3];
            }

            engines.put(model, new Engine(model, power, displacement, efficiency));
        }

        List<Car> cars = new ArrayList<>();

        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            String engine = data[1];
            String weight = "n/a";
            String color = "n/a";

            if (data.length == 3) {
                String current = data[2];

                if (checkForDigits(current)) {
                    weight = current;
                } else {
                    color = current;
                }

            } else if (data.length == 4) {
                weight = data[2];
                color = data[3];
            }

            cars.add(new Car(model, engines.get(engine), weight, color));
        }

        cars.forEach(car -> System.out.println(car.carInfo()));
    }

    private static boolean checkForDigits(String current) {
        for (int i = 0; i < current.length(); i++) {
            if (Character.isDigit(current.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}