package M03_JavaAdvanced.L02_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class T03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeMatrix = Integer.parseInt(scanner.nextLine());

        int[][] matrix = fillMatrix(sizeMatrix, scanner);

        int primary = findPrimaryDiagonal(matrix);
        int secondary = findSecondaryDiagonal(matrix);

        int diffDiagonals = Math.abs(primary - secondary);
        System.out.println(diffDiagonals);
    }

    private static int[][] fillMatrix(int sizeMatrix, Scanner scanner) {
        int[][] matrix = new int[sizeMatrix][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = findElements(scanner);
        }
        return matrix;
    }

    private static int findPrimaryDiagonal(int[][] matrix) {
        int primarySum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    primarySum += matrix[row][col];
                }
            }
        }
        return primarySum;
    }

    private static int findSecondaryDiagonal(int[][] matrix) {
        int primarySum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row + col == matrix.length - 1) {
                    primarySum += matrix[row][col];
                }
            }
        }
        return primarySum;
    }

    private static int[] findElements(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}