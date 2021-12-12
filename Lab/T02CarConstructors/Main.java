package M03_JavaAdvanced.L06_DefiningClasses.Lab.T02CarConstructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            Car car;
            if (data.length == 1) {
                car = new Car(data[0]);
            } else {
                String brand = data[0];
                String model = data[1];
                int horsePowers = Integer.parseInt(data[2]);
                car = new Car(brand, model, horsePowers);
            }
            cars.add(car);
        }

        System.out.println(cars
                .stream()
                .map(Car::carInfo)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}