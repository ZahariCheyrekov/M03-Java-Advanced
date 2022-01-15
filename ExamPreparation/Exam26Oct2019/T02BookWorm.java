package M03_JavaAdvanced.ExamPreparation.Exam26Oct2019;

import java.util.Scanner;

public class T02BookWorm {
    public static char[][] matrix;
    public static int playerRow = 0;
    public static int playerCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        readMatrix(scanner, size);

        findPlayer();

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String direction = command;

            movePlayer(direction, message);

            command = scanner.nextLine();
        }

        System.out.println(message);
        printMatrix();
    }

    private static void movePlayer(String direction, StringBuilder message) {
        int row = playerRow;
        int col = playerCol;

        switch (direction) {
            case "up":
                row--;
                break;

            case "down":
                row++;
                break;

            case "right":
                col++;
                break;

            case "left":
                col--;
                break;
        }

        boolean inBounds = checkIfInBounds(row, col);
        if (inBounds) {
            matrix[playerRow][playerCol] = '-';

            playerRow = row;
            playerCol = col;

            char currentCell = matrix[playerRow][playerCol];

            if (Character.isLetter(currentCell)) {
                message.append(currentCell);
            }
            matrix[playerRow][playerCol] = 'P';

        } else {
            message.deleteCharAt(message.length() - 1);
        }
    }

    private static boolean checkIfInBounds(int row, int col) {
        return (row >= 0) && (row < matrix.length) &&
                (col >= 0) && (col < matrix[row].length);
    }

    private static void findPlayer() {
        boolean hasBeenFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                    hasBeenFound = true;
                    break;
                }
            }

            if (hasBeenFound) {
                break;
            }
        }
    }

    private static void printMatrix() {
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    private static void readMatrix(Scanner scanner, int size) {
        matrix = new char[size][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }
}