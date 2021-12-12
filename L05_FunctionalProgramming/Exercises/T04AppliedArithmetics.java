package M03_JavaAdvanced.L05_FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class T04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String operation = scanner.nextLine();
        while (!operation.equals("end")) {
            switch (operation) {
                case "add":
                    Function<int[], int[]> add = array -> Arrays.stream(array).map(e -> e += 1).toArray();
                    numbers = add.apply(numbers);
                    break;
                case "subtract":
                    Function<int[], int[]> subtract = array -> Arrays.stream(array).map(e -> e -= 1).toArray();
                    numbers = subtract.apply(numbers);
                    break;
                case "multiply":
                    Function<int[], int[]> multiply = array -> array = Arrays.stream(array).map(e -> e *= 2).toArray();
                    numbers = multiply.apply(numbers);
                    break;
                case "print":
                    Consumer<int[]> print = array -> Arrays.stream(array).forEach(num -> System.out.print(num + " "));
                    print.accept(numbers);
                    System.out.println();
                    break;
            }
            operation = scanner.nextLine();
        }
    }
}