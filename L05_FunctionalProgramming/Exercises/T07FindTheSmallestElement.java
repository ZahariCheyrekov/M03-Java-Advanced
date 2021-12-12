package M03_JavaAdvanced.L05_FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class T07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Consumer<List<Integer>> printSmallestNum = list -> {
            int min = Integer.MAX_VALUE;
            for (int num : list) {
                if (min > num) {
                    min = num;
                }
            }
            System.out.println(list.lastIndexOf(min));
        };

        printSmallestNum.accept(numbers);
    }
}