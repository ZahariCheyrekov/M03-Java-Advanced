package M03_JavaAdvanced.ExamPreparation.Exam23October2021;

import java.util.Scanner;

public class T02MouseAndCheese {
    private static char[][] territory;

    private static int mouseRow;
    private static int mouseCol;

    private static int eatenCheese;

    private static boolean wentOut;

    private static int row;
    private static int col;

    private static final int CHEESE_TO_EAT = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        territory = new char[size][size];

        fillTerritory(scanner);

        String direction = scanner.nextLine();
        while (!direction.equals("end")) {

            territory[mouseRow][mouseCol] = '-';
            moveMouse(direction);

            if (wentOut) {
                System.out.println("Where is the mouse?");
                break;
            }

            direction = scanner.nextLine();
        }
        
        if (eatenCheese >= CHEESE_TO_EAT) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n",
                    eatenCheese);

        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",
                    CHEESE_TO_EAT - eatenCheese);
        }

        printTerritory();
    }

    private static void moveMouse(String direction) {
        row = mouseRow;
        col = mouseCol;

        moveDirection(direction);

        boolean inBounds = checkIfInBounds(row, col);
        if (inBounds) {
            char currentCell = territory[row][col];

            switch (currentCell) {
                case 'c':
                    eatenCheese++;
                    break;

                case 'B':
                    territory[row][col] = '-';
                    moveDirection(direction);

                    if (territory[row][col] == 'c') {
                        eatenCheese++;
                    }
                    break;
            }

            mouseRow = row;
            mouseCol = col;

            territory[mouseRow][mouseCol] = 'M';

        } else {
            wentOut = true;
        }
    }

    private static boolean checkIfInBounds(int row, int col) {
        return (row >= 0) && (row < territory.length) &&
                (col >= 0) && (col < territory[row].length);
    }

    private static void moveDirection(String direction) {
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
    }

    private static void fillTerritory(Scanner scanner) {
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

    private static void printTerritory() {
        StringBuilder out = new StringBuilder();

        for (char[] row : territory) {
            for (char col : row) {
                out.append(col);
            }
            out.append(System.lineSeparator());
        }

        System.out.print(out);
    }
}
