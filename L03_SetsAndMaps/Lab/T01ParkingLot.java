package M03_JavaAdvanced.L03_SetsAndMaps.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class T01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> parking = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String carNumber = input.split(", ")[1];

            if (input.contains("IN")) {
                parking.add(carNumber);
            } else if (input.contains("OUT")) {
                parking.remove(carNumber);
            }
            input = scanner.nextLine();
        }
        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join(System.lineSeparator(), parking));
        }
    }
}