package M03_JavaAdvanced.L02_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class T02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] parameters = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = parameters[0];
        int cols = parameters[1];

        String[][] matrix = fillMatrix(rows, cols);

        printMatrix(matrix);
    }

    private static String[][] fillMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String combination = "" + (char) (row + 97) +
                        (char) (97 + row + col) +
                        (char) (row + 97);

                matrix[row][col] = combination;
            }
        }

        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}