package M03_JavaAdvanced.L02_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class T04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = data[0];
        int cols = data[1];

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(findSum(scanner, rows));
    }

    private static int findSum(Scanner scanner, int rows) {
        int sum = 0;
        for (int row = 0; row < rows; row++) {
            int[] elements = readElements(scanner);
            sum += Arrays.stream(elements).sum();
        }

        return sum;
    }

    private static int[] readElements(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}