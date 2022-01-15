package M03_JavaAdvanced.ExamPreparation.Exam19August2020;

import java.util.Scanner;

public class T02Bee {
    public static char[][] territory;

    public static int beeRow;
    public static int beeCol;

    public static int pollinatedFlowers = 0;

    public static boolean disappeared = false;
    public static boolean pollinatedEnough = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        territory = new char[size][size];
        readTerritory(scanner);

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String direction = input;

            territory[beeRow][beeCol] = '.';
            moveBee(direction);

            if (disappeared) {
                break;
            }

            input = scanner.nextLine();
        }

        if (disappeared) {
            System.out.println("The bee got lost!");
        }

        if (pollinatedFlowers >= 5) {
            pollinatedEnough = true;
        }

        if (pollinatedEnough) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);

        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }

        printMatrix();
    }

    private static void moveBee(String direction) {
        int row = beeRow;
        int col = beeCol;

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
                case 'f':
                    pollinatedFlowers++;
                    break;

                case 'O':
                    territory[row][col] = '.';

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

                    if (territory[row][col] == 'f') {
                        pollinatedFlowers++;
                    }

                    break;
            }

            beeRow = row;
            beeCol = col;

            territory[beeRow][beeCol] = 'B';

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

                if (currentChar == 'B') {
                    beeRow = row;
                    beeCol = col;
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