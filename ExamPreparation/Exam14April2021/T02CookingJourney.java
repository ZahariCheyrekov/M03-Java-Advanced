package M03_JavaAdvanced.ExamPreparation.Exam14April2021;

import java.util.Scanner;

public class T02CookingJourney {
    public static char[][] shop;

    public static int bakerRow;
    public static int bakerCol;

    public static int moneyCollected = 0;

    public static boolean collectedEnoughMoney = false;
    public static boolean wentOut = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        shop = new char[size][size];

        readShop(scanner);

        String direction = scanner.nextLine();
        while (!collectedEnoughMoney && !wentOut) {

            shop[bakerRow][bakerCol] = '-';
            moveBaker(direction);

            if (wentOut) {
                break;
            }

            if (collectedEnoughMoney) {
                break;
            }

            direction = scanner.nextLine();
        }

        if (wentOut) {
            System.out.println("Bad news! You are out of the pastry shop.");
        }

        if (collectedEnoughMoney) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.println("Money: " + moneyCollected);

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
            char currentChar = shop[row][col];

            if (Character.isDigit(currentChar)) {
                moneyCollected += Integer.parseInt(String.valueOf(currentChar));

                if (moneyCollected >= 50) {
                    collectedEnoughMoney = true;
                }

                bakerRow = row;
                bakerCol = col;

                shop[bakerRow][bakerCol] = 'S';

            } else if (currentChar == 'P') {
                shop[row][col] = '-';

                int[] otherPillar = findOtherPillar();

                int pillarRow = otherPillar[0];
                int pillarCol = otherPillar[1];

                bakerRow = pillarRow;
                bakerCol = pillarCol;

                shop[bakerRow][bakerCol] = 'S';

            } else if (currentChar == '-') {
                bakerRow = row;
                bakerCol = col;

                shop[bakerRow][bakerCol] = 'S';
            }

        } else {
            wentOut = true;
            shop[bakerRow][bakerCol] = '-';
        }
    }

    private static int[] findOtherPillar() {
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