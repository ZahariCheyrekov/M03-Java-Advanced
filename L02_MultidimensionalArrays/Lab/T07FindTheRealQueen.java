package M03_JavaAdvanced.L02_MultidimensionalArrays.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        readMatrix(scanner);
    }

    private static void readMatrix(Scanner scanner) {
        char[][] matrix = new char[8][8];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int row = 0; row < matrix.length; row++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int col = 0; col < elements.length; col++) {

                char checkQueen = elements[col].charAt(0);
                if (checkQueen == 'q') {
                    queue.offer(row);
                    queue.offer(col);
                }
                matrix[row][col] = elements[col].charAt(0);
            }
        }

        findPositions(matrix, queue);
    }

    private static void findPositions(char[][] matrix, ArrayDeque<Integer> queue) {
        boolean foundFakeQueen;

        while (!queue.isEmpty()) {
            int rowQueen = queue.poll();
            int colQueen = queue.poll();

            foundFakeQueen = false;

            for (int col = 0; col < colQueen; col++) {
                if (matrix[rowQueen][col] == 'q') {
                    foundFakeQueen = true;
                    break;
                }
            }

            for (int col = colQueen + 1; col < 8; col++) {
                if (matrix[rowQueen][col] == 'q') {
                    foundFakeQueen = true;
                    break;
                }
            }

            for (int row = 0; row < rowQueen; row++) {
                if (matrix[row][colQueen] == 'q') {
                    foundFakeQueen = true;
                    break;
                }
            }

            for (int row = rowQueen + 1; row < 8; row++) {
                if (matrix[row][colQueen] == 'q') {
                    foundFakeQueen = true;
                    break;
                }
            }

            int row = rowQueen;
            for (int col = colQueen + 1; col < 8; col++) {
                row++;
                if (row > 7) {
                    break;
                }
                if (matrix[row][col] == 'q') {
                    foundFakeQueen = true;
                    break;
                }
            }

            row = rowQueen;
            for (int col = colQueen - 1; col >= 0; col--) {
                row--;
                if (row < 0) {
                    break;
                }
                if (matrix[row][col] == 'q') {
                    foundFakeQueen = true;
                    break;
                }
            }

            row = rowQueen;
            for (int col = colQueen + 1; col < 8; col++) {
                row--;
                if (row < 0) {
                    break;
                }
                if (matrix[row][col] == 'q') {
                    foundFakeQueen = true;
                    break;
                }
            }

            row = rowQueen;
            for (int col = colQueen - 1; col >= 0; col--) {
                row++;
                if (row > 7) {
                    break;
                }
                if (matrix[row][col] == 'q') {
                    foundFakeQueen = true;
                    break;
                }
            }

            if (!foundFakeQueen) {
                printIndexes(rowQueen, colQueen);
            }
        }
    }

    private static void printIndexes(int rowQueen, int colQueen) {
        System.out.printf("%d %d%n", rowQueen, colQueen);
    }
}