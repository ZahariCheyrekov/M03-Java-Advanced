package M03_JavaAdvanced.ExamPreparation.Exam15December2021;

import java.util.Scanner;

public class T02ThroneConquering {
    private static Scanner scanner = new Scanner(System.in);
    
    private static char[][] field;

    private static int ParisRow;
    private static int ParisCol;

    private static int energy;

    private static boolean died;
    private static boolean reachedHelen;

    public static void main(String[] args) {
        energy = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        field = new char[size][];
        fillField();

        findParis();

        String input = scanner.nextLine();
        while (!died && !reachedHelen) {
            String[] data = input.split("[\\s]+");

            String direction = data[0];
            int enemyRow = Integer.parseInt(data[1]);
            int enemyCol = Integer.parseInt(data[2]);

            field[enemyRow][enemyCol] = 'S';
            field[ParisRow][ParisCol] = '-';

            energy--;

            moveParis(direction);

            if (reachedHelen) {
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                break;
            }

            if (died || energy <= 0) {
                System.out.printf("Paris died at %d;%d.%n", ParisRow, ParisCol);
                field[ParisRow][ParisCol] = 'X';
                break;
            }

            input = scanner.nextLine();
        }

        printField();
    }

    private static void moveParis(String direction) {
        int row = ParisRow;
        int col = ParisCol;

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
            char currentCell = field[row][col];

            ParisRow = row;
            ParisCol = col;

            switch (currentCell) {
                case 'S':
                    energy -= 2;

                    if (energy <= 0) {
                        died = true;
                    }
                    break;

                case 'H':
                    reachedHelen = true;
                    field[ParisRow][ParisCol] = '-';
                    break;

                case '-':
                    field[ParisRow][ParisCol] = 'P';
                    break;
            }


            if (!died && !reachedHelen) {
                field[ParisRow][ParisCol] = 'P';
            }
        }
    }

    private static boolean checkIfInBounds(int row, int col) {
        return (row >= 0) && (row < field.length) &&
                (col >= 0) && (col < field[row].length);
    }

    private static void fillField() {
        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().toCharArray();
        }
    }

    private static void findParis() {
        boolean isFound = false;

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
             
                char currentChar = field[row][col];

                if (currentChar == 'P') {
                    ParisRow = row;
                    ParisCol = col;

                    isFound = true;
                }
            }

            if (isFound) {
                break;
            }
        }
    }

    private static void printField() {
        StringBuilder out = new StringBuilder();

        for (char[] row : field) {
            for (char col : row) {
                out.append(col);
            }
            out.append(System.lineSeparator());
        }

        System.out.print(out);
    }
}
