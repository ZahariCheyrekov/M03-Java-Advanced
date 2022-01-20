package M03_JavaAdvanced.L10_BasicAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class T01RecursiveArraySum {
    public static int[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numbers = Arrays.stream(scanner.nextLine().split("[\\s]+"))
                .mapToInt(Integer::parseInt).toArray();

        long sum = findSum(0);
        System.out.println(sum);
    }

    private static long findSum(int index) {
        if (index >= numbers.length) {
            return 0;
        }

        return numbers[index] + findSum(index + 1);
    }
}