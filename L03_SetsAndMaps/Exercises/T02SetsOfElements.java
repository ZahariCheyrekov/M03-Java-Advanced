package M03_JavaAdvanced.L03_SetsAndMaps.Exercises;

import java.util.*;

public class T02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] setsSizes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int n = setsSizes[0];
        int m = setsSizes[1];

        Set<Integer> firstSet = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }

        Set<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < m; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }
        firstSet.retainAll(secondSet);

        firstSet.forEach(e -> System.out.print(e + " "));
    }
}