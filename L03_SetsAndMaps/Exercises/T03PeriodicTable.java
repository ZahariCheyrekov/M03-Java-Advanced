package M03_JavaAdvanced.L03_SetsAndMaps.Exercises;

import java.util.*;

public class T03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> chemicalElements = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split("\\s+");
            Collections.addAll(chemicalElements, elements);
        }
        chemicalElements.forEach(e -> System.out.print(e + " "));
    }
}