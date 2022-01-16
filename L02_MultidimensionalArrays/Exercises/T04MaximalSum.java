package M03_JavaAdvanced.L02_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class T04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] parameters = findElements(scanner);

        int rows = parameters[0];
        int cols = parameters[1];

        int[][] matrix = fillMatrix(rows, cols, scanner);

        findMaximum(matrix);
    }

    private static void findMaximum(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;

        int maxRow = 0;
        int maxCol = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
        System.out.printf("Sum = %d%n", maxSum);

        printFinalMatrix(maxRow, maxCol, matrix);
    }

    private static void printFinalMatrix(int maxRow, int maxCol, int[][] matrix) {
        for (int row = maxRow; row < maxRow + 3; row++) {
            for (int col = maxCol; col < maxCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int[] elements = findElements(scanner);
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = elements[col];
            }
        }
        return matrix;
    }

    private static int[] findElements(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}