package M03_JavaAdvanced.ExamPreparation.Exam22Feb2020;

import java.util.Scanner;

public class T02ReVolt {
    private static char[][] matrix;

    private static int playerRow;
    private static int playerCol;

    private static boolean haveWon = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());

        matrix = new char[size][size];
        readMatrix(scanner);

        String input = scanner.nextLine();
        while (countCommands > 0) {
            String direction = input;
            countCommands--;

            matrix[playerRow][playerCol] = '-';
            movePlayer(direction);

            if (haveWon) {
                break;
            }

            if (countCommands <= 0) {
                break;
            }

            input = scanner.nextLine();
        }

        if (haveWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix();
    }

    private static void movePlayer(String direction) {
        int row = playerRow;
        int col = playerCol;

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

        boolean inBounds = checkIfInBounds(row, col);
        if (inBounds) {

            char currentCell = matrix[row][col];

            switch (currentCell) {
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
                case 'F':
                    haveWon = true;
                    break;
            }
        }

        if (!haveWon) {

            if (row >= matrix.length) {
                row = 0;
            } else if (row < 0) {
                row = matrix.length - 1;
            }

            if (col >= matrix[row].length) {
                col = 0;
            } else if (col < 0) {
                col = matrix[row].length - 1;
            }

        }

        playerRow = row;
        playerCol = col;

        if (matrix[playerRow][playerCol] == 'F') {
            haveWon = true;
        }

        matrix[playerRow][playerCol] = 'f';
    }

    private static boolean checkIfInBounds(int row, int col) {
        return (row >= 0) && (row < matrix.length) &&
                (col >= 0) && (col < matrix[row].length);
    }

    private static void readMatrix(Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] elements = scanner.nextLine().split("");
            for (int col = 0; col < elements.length; col++) {
                char currentChar = elements[col].charAt(0);

                if (currentChar == 'f') {
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
