package M03_JavaAdvanced.L02_MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimension = findElements(scanner);

        int rows = dimension[0];
        int cols = dimension[1];

        List<List<Integer>> matrix = new ArrayList<>();
        fillMatrix(matrix, rows, cols);

        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] numbers = input.split("\\s+");

            int row = Integer.parseInt(numbers[0]);
            int col = Integer.parseInt(numbers[1]);
            int radius = Integer.parseInt(numbers[2]);

            for (int i = row - radius; i <= row + radius; i++) {
                if (isInMatrix(i, col, matrix) && i != row) {
                    matrix.get(i).remove(col);
                }
            }

            for (int i = col + radius; i >= col - radius; i--) {
                if (isInMatrix(row, i, matrix)) {
                    matrix.get(row).remove(i);
                }
            }
            matrix.removeIf(List::isEmpty);

            input = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static boolean isInMatrix(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int number = 1;

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(number++);
            }
        }
    }

    private static int[] findElements(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}