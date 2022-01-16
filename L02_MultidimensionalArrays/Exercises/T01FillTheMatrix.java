package M03_JavaAdvanced.L02_MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class T01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] elements = scanner.nextLine().split(",\\s+");

        int size = Integer.parseInt(elements[0]);
        String pattern = elements[1];

        switch (pattern) {
            case "A":
                int[][] matrixA = fillMatrixA(size);
                printMatrix(matrixA);
                break;

            case "B":
                int[][] matrixB = fillMatrixB(size);
                printMatrix(matrixB);
                break;
        }
    }

    private static int[][] fillMatrixA(int size) {
        int[][] matrix = new int[size][size];

        int num = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = num++;
            }
        }
        return matrix;
    }

    private static int[][] fillMatrixB(int size) {
        int[][] matrix = new int[size][size];

        int num = 1;
        for (int col = 0; col < size; col++) {

            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = num++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = num++;
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}