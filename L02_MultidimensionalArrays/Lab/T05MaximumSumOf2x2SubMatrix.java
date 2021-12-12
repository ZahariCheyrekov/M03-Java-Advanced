package M03_JavaAdvanced.L02_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class T05MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] parameters = findElements(scanner, ", ");

        int rows = parameters[0];
        int cols = parameters[1];

        readMatrix(scanner, rows, cols);
    }

    private static void readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int[] elements = findElements(scanner, ", ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = elements[col];
            }
        }

        findMaximum(matrix);
    }

    private static void findMaximum(int[][] matrix) {
        int bestRow = 0;
        int bestCol = 0;

        int bestSum = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (bestSum < sum) {
                    bestSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        int elOne = matrix[bestRow][bestCol];
        int elTwo = matrix[bestRow][bestCol + 1];
        int elThree = matrix[bestRow + 1][bestCol];
        int elFour = matrix[bestRow + 1][bestCol + 1];

        System.out.println(elOne + " " + elTwo);
        System.out.println(elThree + " " + elFour);
        System.out.println(bestSum);
    }

    private static int[] findElements(Scanner scanner, String regex) {
        return Arrays.stream(scanner.nextLine().split(regex)).mapToInt(Integer::parseInt)
                .toArray();
    }
}