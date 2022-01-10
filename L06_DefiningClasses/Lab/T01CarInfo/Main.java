package M03_JavaAdvanced.L06_DefiningClasses.Lab.T01CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String brand = data[0];
            String model = data[1];
            int horsePowers = Integer.parseInt(data[2]);

            Car car = new Car(brand, model, horsePowers);
            cars.add(car);
        }
        for (Car car : cars) {
            car.carInfo();
        }
    }
}