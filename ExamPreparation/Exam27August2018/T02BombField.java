package M03_JavaAdvanced.ExamPreparation.Exam27August2018;

import java.util.Scanner;

public class T02BombField {
    private static Scanner scanner;

    private static char[][] field;

    private static int sapperRow;
    private static int sapperCol;

    private static int allBombs;
    private static int foundBombs;

    private static boolean gameOver;
    private static boolean foundAllBombs;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split("[,\\s]+");

        field = new char[size][size];
        fillField();

        int index = 0;
        while (index != commands.length) {
            String direction = commands[index++];

            moveSapper(direction);

            if (gameOver) {
                System.out.printf("END! %d bombs left on the field%n", allBombs - foundBombs);
                break;
            }

            if (foundAllBombs) {
                System.out.println("Congratulations! You found all bombs!");
                break;
            }
        }

        if (!foundAllBombs && !gameOver) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n",
                    allBombs - foundBombs, sapperRow, sapperCol);
        }
    }

    private static void moveSapper(String direction) {
        field[sapperRow][sapperCol] = '+';

        int row = sapperRow;
        int col = sapperCol;

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
            char fieldChar = field[row][col];

            switch (fieldChar) {
                case 'B':
                    foundBombs++;
                    System.out.println("You found a bomb!");

                    if (allBombs == foundBombs) {
                        foundAllBombs = true;
                    }
                    break;

                case 'e':
                    gameOver = true;
                    break;
            }

            sapperRow = row;
            sapperCol = col;

            field[sapperRow][sapperCol] = 's';
        }
    }

    private static boolean checkIfInBounds(int row, int col) {
        return (row >= 0) && (row < field.length) &&
                (col >= 0) && (col < field[row].length);
    }


    private static void fillField() {
        for (int row = 0; row < field.length; row++) {
            String[] elements = scanner.nextLine().split("[\\s]+");

            for (int col = 0; col < elements.length; col++) {
                char currentChar = elements[col].charAt(0);

                if (currentChar == 's') {
                    sapperRow = row;
                    sapperCol = col;
                }

                if (currentChar == 'B') {
                    allBombs++;
                }

                field[row][col] = currentChar;
            }
        }
    }
}