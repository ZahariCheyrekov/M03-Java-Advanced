package M03_JavaAdvanced.L02_MultidimensionalArrays.Lab;

import java.util.Scanner;

public class T03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] matrixOne = readMatrix(scanner, rows, cols);
        char[][] matrixTwo = readMatrix(scanner, rows, cols);

        char[][] resultMatrix = compareAndEditMatrices(matrixOne, matrixTwo, rows, cols);

        printMatrix(resultMatrix);
    }

    private static void printMatrix(char[][] resultMatrix) {
        for (char[] matrix : resultMatrix) {
            for (char current : matrix) {
                System.out.print(current + " ");
            }
            System.out.println();
        }
    }

    private static char[][] compareAndEditMatrices(char[][] matrixOne, char[][] matrixTwo, int rows, int cols) {
        char[][] resultMatrix = new char[rows][cols];

        for (int row = 0; row < matrixOne.length; row++) {
            for (int col = 0; col < matrixOne[row].length; col++) {
                if (matrixOne[row][col] != matrixTwo[row][col]) {
                    resultMatrix[row][col] = '*';
                } else {
                    resultMatrix[row][col] = matrixOne[row][col];
                }
            }
        }

        return resultMatrix;
    }

    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int col = 0; col < elements.length; col++) {
                matrix[row][col] = elements[col].charAt(0);
            }
        }
        return matrix;
    }
}