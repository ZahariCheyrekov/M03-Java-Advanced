package M03_JavaAdvanced.ExamPreparation.Exam18August2021;

import java.util.Scanner;

public class T02FormulaOne {
    private static char[][] matrix;

    private static int playerRow;
    private static int playerCol;

    private static boolean reachedFinish;

    public static int row;
    public static int col;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int countOfCommands = Integer.parseInt(scanner.nextLine());

        matrix = new char[size][size];
        fillMatrix(scanner);

        String direction = scanner.nextLine();
        while (!reachedFinish) {
            countOfCommands--;

            matrix[playerRow][playerCol] = '.';
            movePlayer(direction);

            if (reachedFinish) {
                System.out.println("Well done, the player won first place!");
                break;
            }

            if (countOfCommands == 0) {
                System.out.println("Oh no, the player got lost on the track!");
                break;
            }

            direction = scanner.nextLine();
        }

        printMatrix();
    }

    private static void movePlayer(String direction) {
        row = playerRow;
        col = playerCol;

        moveDirection(direction, ' ');

        boolean inBounds = checkIfInBounds(row, col);

        if (inBounds) {
            char cell = matrix[row][col];

            checkCurrentCell(cell, direction);
        }

        if (row < 0) {
            row = matrix.length - 1;

        } else if (row >= matrix.length) {
            row = 0;

        } else if (col < 0) {
            col = matrix[row].length - 1;

        } else if (col >= matrix[row].length) {
            col = 0;
        }

        playerRow = row;
        playerCol = col;

        matrix[playerRow][playerCol] = 'P';
    }

    private static void checkCurrentCell(char cell, String direction) {
        switch (cell) {
            case 'B':
                moveDirection(direction, 'B');
                break;

            case 'T':
                moveDirection(direction, 'T');
                break;

            case 'F':
                reachedFinish = true;
                break;
        }
    }

    private static void moveDirection(String direction, char cell) {
        switch (cell) {
            case ' ':
            case 'B':

                switch (direction) {
                    case "up":
                        row--;
                        break;

                    case "down":
                        row++;
                        break;

                    case "left":
                        col--;
                        break;

                    case "right":
                        col++;
                        break;
                }

                break;

            case 'T':
                switch (direction) {
                    case "up":
                        row++;
                        break;

                    case "down":
                        row--;
                        break;

                    case "left":
                        col++;
                        break;

                    case "right":
                        col--;
                        break;
                }

                break;
        }
    }

    private static boolean checkIfInBounds(int row, int col) {
        return (row >= 0) && (row < matrix.length) &&
                (col >= 0) && (col < matrix[row].length);
    }

    private static void fillMatrix(Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] elements = scanner.nextLine().split("");

            for (int col = 0; col < elements.length; col++) {
                char currentChar = elements[col].charAt(0);

                if (currentChar == 'P') {
                    playerRow = row;
                    playerCol = col;
                }

                matrix[row][col] = currentChar;
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
}
