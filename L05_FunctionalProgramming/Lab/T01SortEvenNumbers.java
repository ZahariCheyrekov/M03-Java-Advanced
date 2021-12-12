package M03_JavaAdvanced.L05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class T01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .toArray();

        String evenNumbers = Arrays.stream(numbers).mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(evenNumbers);

        String sortedNumbers = Arrays.stream(numbers).sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(sortedNumbers);
    }
}