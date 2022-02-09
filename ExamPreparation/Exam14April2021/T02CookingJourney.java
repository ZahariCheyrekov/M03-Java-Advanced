package M03_JavaAdvanced.ExamPreparation.Exam14April2021;

import java.util.Scanner;

public class T02CookingJourney {
    private static char[][] shop;

    private static int bakerRow;
    private static int bakerCol;

    private static int collectedMoney;

    private static boolean outOfShop;
    private static boolean collectedEnoughMoney;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        shop = new char[size][size];

        readShop(scanner);

        String direction = scanner.nextLine();
        while (!outOfShop) {

            shop[bakerRow][bakerCol] = '-';
            moveBaker(direction);

            if (outOfShop) {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }

            if (collectedEnoughMoney) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }

            direction = scanner.nextLine();
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

            case "left":
                col--;
                break;

            case "right":
                col++;
                break;
        }

        boolean inBounds = checkIfInBounds(row, col);
        if (inBounds) {
            char currentCell = shop[row][col];

            if (Character.isDigit(currentCell)) {
                collectedMoney += Integer.parseInt(String.valueOf(currentCell));

                if (collectedMoney >= 50) {
                    collectedEnoughMoney = true;
                }

            } else if (currentCell == 'P') {
                shop[row][col] = '-';

                int[] secondPillar = findPillar();

                int pillarRow = secondPillar[0];
                int pillarCol = secondPillar[1];

                row = pillarRow;
                col = pillarCol;
            }

            bakerRow = row;
            bakerCol = col;

            shop[bakerRow][bakerCol] = 'S';

        } else {
            outOfShop = true;
        }
    }

    private static int[] findPillar() {
        int[] pillarCoordinates = new int[2];
        boolean hasBeenFound = false;

        for (int row = 0; row < shop.length; row++) {
            for (int col = 0; col < shop[row].length; col++) {
                char currentChar = shop[row][col];

                if (currentChar == 'P') {
                    pillarCoordinates[0] = row;
                    pillarCoordinates[1] = col;

                    hasBeenFound = true;
                }
            }

            if (hasBeenFound) {
                break;
            }
        }

        return pillarCoordinates;
    }

    private static boolean checkIfInBounds(int row, int col) {
        return (row >= 0) && (row < shop.length) &&
                (col >= 0) && (col < shop[row].length);
    }

    private static void readShop(Scanner scanner) {
        for (int row = 0; row < shop.length; row++) {
            String[] elements = scanner.nextLine().split("");

            for (int col = 0; col < elements.length; col++) {
                char currentChar = elements[col].charAt(0);

                if (currentChar == 'S') {
                    bakerRow = row;
                    bakerCol = col;
                }

                shop[row][col] = currentChar;
            }
        }
    }

    private static void printMatrix() {
        for (char[] row : shop) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}
