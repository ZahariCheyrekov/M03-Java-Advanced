package M03_JavaAdvanced.ExamPreparation.Exam23October2021;

import java.util.Scanner;

public class T02MouseAndCheese {
    public static char[][] territory;

    public static int mouseRow;
    public static int mouseCol;

    public static int cheeseEaten = 0;

    public static boolean disappeared = false;
    public static boolean enoughCheese = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        territory = new char[size][size];
        readTerritory(scanner);

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String direction = input;

            territory[mouseRow][mouseCol] = '-';
            moveMouse(direction);

            if (disappeared) {
                break;
            }

            input = scanner.nextLine();
        }

        if (disappeared) {
            System.out.println("Where is the mouse?");
        }

        if (cheeseEaten >= 5) {
            enoughCheese = true;
        }

        if (enoughCheese) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);

        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEaten);
        }

        printMatrix();
    }

    private static void moveMouse(String direction) {
        int row = mouseRow;
        int col = mouseCol;

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
            char currentCell = territory[row][col];

            switch (currentCell) {
                case 'c':
                    cheeseEaten++;
                    break;

                case 'B':
                    territory[row][col] = '-';

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

                    if (territory[row][col] == 'c') {
                        cheeseEaten++;
                    }
                    break;
            }

            mouseRow = row;
            mouseCol = col;

            territory[mouseRow][mouseCol] = 'M';

        } else {
            disappeared = true;
        }
    }

    private static boolean checkIfInBounds(int row, int col) {
        return (row >= 0) && (row < territory.length) &&
                (col >= 0) && (col < territory[row].length);
    }

    private static void readTerritory(Scanner scanner) {
        for (int row = 0; row < territory.length; row++) {
            String[] elements = scanner.nextLine().split("");

            for (int col = 0; col < elements.length; col++) {
                char currentChar = elements[col].charAt(0);

                if (currentChar == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                }

                territory[row][col] = currentChar;
            }
        }
    }

    private static void printMatrix() {
        for (char[] row : territory) {
            for (char col : row) {
                System.out.print(col);
            }

            System.out.println();
        }
    }
}