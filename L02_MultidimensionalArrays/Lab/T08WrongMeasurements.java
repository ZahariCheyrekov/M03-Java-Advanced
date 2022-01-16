package M03_JavaAdvanced.L02_MultidimensionalArrays.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(scanner, rows);

        int[] indexes = findElements(scanner);

        int rowIndex = indexes[0];
        int colIndex = indexes[1];

        int wrongValue = matrix[rowIndex][colIndex];

        int[][] changedMatrix = changeMatrixElements(matrix, wrongValue);
        printMatrix(changedMatrix);
    }

    private static void printMatrix(int[][] changedMatrix) {
        for (int[] row : changedMatrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private static int[][] changeMatrixElements(int[][] matrix, int wrongValue) {
        List<Integer> changeElements = new ArrayList<>();
        int sumWrongElement = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] == wrongValue) {
                    //looking for right directions

                    //top element
                    if (row > 0 && matrix[row - 1][col] != wrongValue) {
                        sumWrongElement += matrix[row - 1][col];
                    }
                    //left element
                    if (col > 0 && matrix[row][col - 1] != wrongValue) {
                        sumWrongElement += matrix[row][col - 1];
                    }
                    //right element
                    if (col < matrix[row].length - 1 && matrix[row][col + 1] != wrongValue) {
                        sumWrongElement += matrix[row][col + 1];
                    }
                    //bottom element
                    if (row < matrix.length - 1 && matrix[row + 1][col] != wrongValue) {
                        sumWrongElement += matrix[row + 1][col];
                    }
                    changeElements.add(row);
                    changeElements.add(col);
                    changeElements.add(sumWrongElement);

                    sumWrongElement = 0;
                }
            }
        }

        for (int i = 0; i < changeElements.size(); i += 3) {
            int row = changeElements.get(i);
            int col = changeElements.get(i + 1);
            int sum = changeElements.get(i + 2);

            matrix[row][col] = sum;
        }
        return matrix;
    }

    private static int[][] readMatrix(Scanner scanner, int rows) {
        int[][] matrix = new int[rows][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = findElements(scanner);
        }
        return matrix;
    }

    private static int[] findElements(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}