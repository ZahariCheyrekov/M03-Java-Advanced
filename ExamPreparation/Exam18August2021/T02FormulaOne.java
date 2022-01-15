package M03_JavaAdvanced.ExamPreparation.Exam18August2021;

import java.util.Scanner;

public class T02FormulaOne {
    public static char[][] area;

    public static int playerRow;
    public static int playerCol;

    public static boolean reachedFinish = false;

    public static int row;
    public static int col;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());

        area = new char[size][size];
        readArea(scanner);

        String direction = scanner.nextLine();
        while (!reachedFinish) {
            countCommands--;

            area[playerRow][playerCol] = '.';
            movePlayer(direction);

            if (reachedFinish) {
                System.out.println("Well done, the player won first place!");
                break;
            }

            if (countCommands == 0) {
                System.out.println("Oh no, the player got lost on the track!");
                break;
            }

            direction = scanner.nextLine();
        }

        printArea();
    }

    private static void movePlayer(String direction) {
        row = playerRow;
        col = playerCol;

        moveDirection(direction, ' ');

        boolean inBounds = checkIfInBounds(row, col);

        if (inBounds) {
            char cell = area[row][col];

            checkCurrentCell(cell, direction);
        }

        if (row < 0) {
            row = area.length - 1;

        } else if (row >= area.length) {
            row = 0;

        } else if (col < 0) {
            col = area[row].length - 1;

        } else if (col >= area[row].length) {
            col = 0;
        }

        char cell = area[row][col];

        checkCurrentCell(cell, direction);

        playerRow = row;
        playerCol = col;

        area[playerRow][playerCol] = 'P';
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
        return (row >= 0) && (row < area.length) &&
                (col >= 0) && (col < area[row].length);
    }

    private static void readArea(Scanner scanner) {
        for (int row = 0; row < area.length; row++) {
            String[] elements = scanner.nextLine().split("");

            for (int col = 0; col < elements.length; col++) {
                char currentChar = elements[col].charAt(0);

                if (currentChar == 'P') {
                    playerRow = row;
                    playerCol = col;
                }

                area[row][col] = currentChar;
            }
        }
    }

    private static void printArea() {
        for (char[] row : area) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}