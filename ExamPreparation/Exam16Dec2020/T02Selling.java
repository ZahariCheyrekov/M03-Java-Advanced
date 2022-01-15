package M03_JavaAdvanced.ExamPreparation.Exam16Dec2020;

import java.util.Scanner;

public class T02Selling {
    public static char[][] bakery;

    public static int bakerRow;
    public static int bakerCol;

    public static int collectedMoney = 0;

    public static boolean outOfBakery = false;
    public static boolean collectedEnoughMoney = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        bakery = new char[size][size];

        readRows(scanner);

        String input = scanner.nextLine();
        while (!outOfBakery && !collectedEnoughMoney) {
            String direction = input;

            bakery[bakerRow][bakerCol] = '-';
            moveBaker(direction);

            if (outOfBakery) {
                break;
            }

            if (collectedEnoughMoney) {
                break;
            }

            input = scanner.nextLine();
        }

        if (outOfBakery) {
            System.out.println("Bad news, you are out of the bakery.");
        }

        if (collectedEnoughMoney) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.println("Money: " + collectedMoney);

        printMatrix();
    }

    private static void moveBaker(String direction) {
        int row = bakerRow;
        int col = bakerCol;

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
            char currentCell = bakery[row][col];

            if (Character.isDigit(currentCell)) {
                collectedMoney += Integer.parseInt(String.valueOf(currentCell));

                if (collectedMoney >= 50) {
                    collectedEnoughMoney = true;
                }

                bakerRow = row;
                bakerCol = col;

                bakery[bakerRow][bakerCol] = 'S';

            } else if (currentCell == 'O') {
                bakery[row][col] = '-';

                int[] otherPillar = findCoordinates();

                int pillarRow = otherPillar[0];
                int pillarCol = otherPillar[1];

                bakery[pillarRow][pillarCol] = 'S';

                bakerRow = pillarRow;
                bakerCol = pillarCol;

            } else {
                bakerRow = row;
                bakerCol = col;

                bakery[bakerRow][bakerCol] = 'S';
            }

        } else {
            outOfBakery = true;
        }
    }

    private static int[] findCoordinates() {
        int[] coordinates = new int[2];
        boolean hasBeenFound = false;

        for (int row = 0; row < bakery.length; row++) {
            for (int col = 0; col < bakery[row].length; col++) {
                char currentCell = bakery[row][col];

                if (currentCell == 'O') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    hasBeenFound = true;
                }
            }

            if (hasBeenFound) {
                break;
            }
        }

        return coordinates;
    }

    private static boolean checkIfInBounds(int row, int col) {
        return (row >= 0) && (row < bakery.length) &&
                (col >= 0) && (col < bakery[row].length);
    }

    private static void readRows(Scanner scanner) {
        for (int row = 0; row < bakery.length; row++) {
            String[] elements = scanner.nextLine().split("");

            for (int col = 0; col < elements.length; col++) {
                char currentCell = elements[col].charAt(0);

                if (currentCell == 'S') {
                    bakerRow = row;
                    bakerCol = col;
                }

                bakery[row][col] = currentCell;
            }
        }
    }

    private static void printMatrix() {
        for (char[] row : bakery) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}