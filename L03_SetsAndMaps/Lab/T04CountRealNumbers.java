package M03_JavaAdvanced.L03_SetsAndMaps.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class T04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> occurrences = new LinkedHashMap<>();
        for (double num : numbers) {
            occurrences.putIfAbsent(num, 0);
            occurrences.put(num, occurrences.get(num) + 1);
        }
        occurrences.forEach((k, v) -> System.out.printf("%.1f -> %d%n", k, v));
    }
}