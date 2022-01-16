package M03_JavaAdvanced.L02_MultidimensionalArrays.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());

        findDiagonals(matrixSize, scanner);
    }

    private static void findDiagonals(int matrixSize, Scanner scanner) {
        List<String> firstDiagonal = new ArrayList<>();
        List<String> secondDiagonal = new ArrayList<>();
        int[][] matrix = new int[matrixSize][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = findElements(scanner);
        }

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                if (row == col) {
                    firstDiagonal.add(String.valueOf(matrix[row][col]));
                    break;
                }
            }
        }

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                if ((row + col) == matrixSize - 1) {
                    secondDiagonal.add(String.valueOf(matrix[row][col]));
                    break;
                }
            }
        }
        System.out.println(String.join(" ", firstDiagonal));

        for (int i = secondDiagonal.size() - 1; i >= 0; i--) {
            System.out.print(secondDiagonal.get(i) + " ");
        }
    }

    private static int[] findElements(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}