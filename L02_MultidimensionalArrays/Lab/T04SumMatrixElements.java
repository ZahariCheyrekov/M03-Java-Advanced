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
        System.out.println(findSum(scanner, rows, cols));
    }

    private static int findSum(Scanner scanner, int rows, int cols) {
        int sum = 0;

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            int[] elements = readElements(scanner);
            for (int col = 0; col < matrix[row].length; col++) {
                sum += elements[col];
            }
        }
        return sum;
    }

    private static int[] readElements(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}