package M03_JavaAdvanced.ExamPreparation.Exam28June2020;

import java.util.Scanner;

public class T02Snake {
    public static char[][] matrix;

    public static int snakeRow;
    public static int snakeCol;

    public static boolean hasEaten = false;
    public static boolean wentOutside = false;

    public static int foodEaten = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        matrix = new char[size][size];
        readMatrix(scanner);

        String input = scanner.nextLine();
        while (!wentOutside && !hasEaten) {
            String direction = input;

            matrix[snakeRow][snakeCol] = '.';
            moveSnake(direction);

            if (wentOutside || hasEaten) {
                break;
            }

            input = scanner.nextLine();
        }

        if (wentOutside) {
            System.out.println("Game over!");
        }

        if (hasEaten) {
            System.out.println("You won! You fed the snake.");
        }

        System.out.printf("Food eaten: %d%n", foodEaten);

        printMatrix();
    }

    private static void moveSnake(String direction) {
        int row = snakeRow;
        int col = snakeCol;

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

            snakeRow = row;
            snakeCol = col;

            switch (currentCell) {
                case '*':
                    matrix[snakeRow][snakeCol] = 'S';
                    foodEaten++;

                    if (foodEaten >= 10) {
                        hasEaten = true;
                    }
                    break;

                case 'B':
                    matrix[row][col] = '.';
                    int[] secondBCoordinates = findCoordinates();

                    int rowB = secondBCoordinates[0];
                    int colB = secondBCoordinates[1];

                    snakeRow = rowB;
                    snakeCol = colB;

                    matrix[snakeRow][snakeCol] = 'S';
                    break;
            }
        } else {
            wentOutside = true;
        }
    }

    private static int[] findCoordinates() {
        int[] coordinates = new int[2];
        boolean hasBeefFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                char currentCell = matrix[row][col];

                if (currentCell == 'B') {
                    coordinates[0] = row;
                    coordinates[1] = col;

                    hasBeefFound = true;
                    break;
                }
            }
            if (hasBeefFound) {
                break;
            }
        }

        return coordinates;
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

                if (currentChar == 'S') {
                    snakeRow = row;
                    snakeCol = col;
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