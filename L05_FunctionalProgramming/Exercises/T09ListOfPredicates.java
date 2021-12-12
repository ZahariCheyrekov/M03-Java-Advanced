package M03_JavaAdvanced.L05_FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class T09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(i + 1);
        }

        Integer[] divisors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Predicate<Integer> check = (i) -> {
            for (Integer a : divisors) {
                if (a == 0)
                    continue;
                if (i % a != 0)
                    return false;
            }
            return true;
        };

        for (Integer num : arr)
            if (check.test(num))
                System.out.printf("%d ", num);
    }
}