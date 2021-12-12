package M03_JavaAdvanced.L02_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class T05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] parameters = readElements(scanner);

        int rows = parameters[0];
        int cols = parameters[1];

        String[][] matrix = fillMatrix(rows, cols, scanner);

        String input = scanner.nextLine();
        while (!input.equals("END")) {

            if (input.contains("swap")) {
                String[] elements = input.split("\\s+");

                if (elements.length != 5) {
                    System.out.println("Invalid input!");
                } else {
                    int firstIndex = Integer.parseInt(elements[1]);
                    int secondIndex = Integer.parseInt(elements[2]);
                    int firstIndexSwap = Integer.parseInt(elements[3]);
                    int secondIndexSwap = Integer.parseInt(elements[4]);

                    //check indexes
                    boolean areCorrect = checkIndexes(firstIndex, secondIndex, firstIndexSwap,
                            secondIndexSwap, matrix);

                    if (areCorrect) {
                        String currentElement = matrix[firstIndex][secondIndex];
                        String swapElement = matrix[firstIndexSwap][secondIndexSwap];

                        matrix[firstIndex][secondIndex] = swapElement;
                        matrix[firstIndexSwap][secondIndexSwap] = currentElement;

                        printMatrix(matrix);
                    } else {
                        System.out.println("Invalid input!");
                    }
                }
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    private static boolean checkIndexes(int first, int second, int third, int forth, String[][] matrix) {
        return first >= 0 && first <= matrix.length &&
                second >= 0 && second <= matrix.length &&
                third >= 0 && third <= matrix.length &&
                forth >= 0 && forth <= matrix.length;
    }

    private static String[][] fillMatrix(int rows, int cols, Scanner scanner) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = elements[col];
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

    private static int[] readElements(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}