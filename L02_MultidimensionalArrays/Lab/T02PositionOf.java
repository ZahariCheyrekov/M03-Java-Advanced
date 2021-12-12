package M03_JavaAdvanced.L02_MultidimensionalArrays.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T02PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] parameters = readAndSplitElements(scanner, "\\s+");

        int rowsMatrix = parameters[0];
        int colsMatrix = parameters[1];

        int[][] matrix = readMatrix(rowsMatrix, colsMatrix, scanner);

        int number = Integer.parseInt(scanner.nextLine());

        List<String> positionsList = findPositions(matrix, number);
        if (positionsList.isEmpty()) {
            System.out.println("not found");
        } else {
            for (String position : positionsList) {
                System.out.println(position);
            }
        }
    }

    private static List<String> findPositions(int[][] matrix, int number) {
        List<String> positionsList = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumber = matrix[row][col];
                if (currentNumber == number) {
                    positionsList.add(row + " " + col);
                }
            }
        }
        return positionsList;
    }

    private static int[][] readMatrix(int rowsMatrix, int colsMatrix, Scanner scanner) {
        int[][] matrix = new int[rowsMatrix][colsMatrix];

        for (int row = 0; row < matrix.length; row++) {
            int[] elements = readAndSplitElements(scanner, "\\s+");
            for (int cols = 0; cols < matrix[row].length; cols++) {
                matrix[row][cols] = elements[cols];
            }
        }
        return matrix;
    }

    private static int[] readAndSplitElements(Scanner scanner, String regex) {
        return Arrays.stream(scanner.nextLine().split(regex))
                .mapToInt(Integer::parseInt).toArray();
    }
}