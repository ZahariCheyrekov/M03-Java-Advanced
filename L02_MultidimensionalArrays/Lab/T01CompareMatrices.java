package M03_JavaAdvanced.L02_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class T01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstMatrixParameters = readAndSplitElements(scanner, "\\s+");
        int rows = firstMatrixParameters[0];
        int columns = firstMatrixParameters[1];

        int[][] matrixOne = readMatrix(rows, columns, scanner);

        int[] secondMatrixParameters = readAndSplitElements(scanner, "\\s+");
        int rowsTwo = secondMatrixParameters[0];
        int cols = secondMatrixParameters[1];

        int[][] matrixTwo = readMatrix(rowsTwo, cols, scanner);
        boolean areIdentical = compareMatrices(matrixOne, matrixTwo);

        if (areIdentical) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean compareMatrices(int[][] matrixOne, int[][] matrixTwo) {
        if (matrixOne.length != matrixTwo.length) {
            return false;
        }

        for (int row = 0; row < matrixOne.length; row++) {
            if (matrixOne[row].length != matrixTwo[row].length) {
                return false;
            }
            for (int col = 0; col < matrixOne[row].length; col++) {
                if (matrixOne[row][col] != matrixTwo[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] readMatrix(int rows, int columns, Scanner scanner) {
        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            int[] elements = readAndSplitElements(scanner, "\\s+");
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = elements[column];
            }
        }
        return matrix;
    }

    private static int[] readAndSplitElements(Scanner scanner, String separator) {
        return Arrays.stream(scanner.nextLine().split(separator))
                .mapToInt(Integer::parseInt).toArray();
    }
}