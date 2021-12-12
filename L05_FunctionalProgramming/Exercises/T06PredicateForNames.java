package M03_JavaAdvanced.L05_FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class T06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());

        String[] names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(name -> name.length() <= length)
                .toArray(String[]::new);

        Arrays.stream(names).forEach(System.out::println);
    }
}