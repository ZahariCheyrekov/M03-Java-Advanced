package M03_JavaAdvanced.L05_FunctionalProgramming.Lab;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class T06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");

        int lower = Integer.parseInt(tokens[0]);
        int upper = Integer.parseInt(tokens[1]);

        String oddOrEven = scanner.nextLine();

        Predicate<Integer> evenOrOdd = getFilter(oddOrEven);

        Consumer<Integer> printer = x -> System.out.print(x + " ");

        IntStream
                .rangeClosed(lower, upper)
                .boxed()
                .filter(evenOrOdd)
                .forEach(printer);
    }

    public static Predicate<Integer> getFilter(String oddOrEven) {
        if (oddOrEven.equals("odd")) {
            return x -> x % 2 != 0;
        }
        return x -> x % 2 == 0;
    }
}