package M03_JavaAdvanced.ExamPreparation.Exam15December2021;

import java.util.Scanner;

public class T02ThroneConquering {
    public static char[][] matrix;

    public static int ParisRow = 0;
    public static int ParisCol = 0;

    public static boolean reachedHelen;

    public static int energy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());

        readMatrix(rows, scanner);

        findParis();

        reachedHelen = false;
        while (energy > 0) {

            if (reachedHelen) {
                break;
            }

            String[] commands = scanner.nextLine().split("\\s+");

            String direction = commands[0];
            int row = Integer.parseInt(commands[1]);
            int col = Integer.parseInt(commands[2]);

            energy--;

            matrix[row][col] = 'S';

            moveParis(direction);

        }

        if (energy <= 0) {
            System.out.printf("Paris died at %d;%d.%n", ParisRow, ParisCol);
        }

        if (reachedHelen) {
            System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
        }

        printMatrix();
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

            case "left":
                col--;
                break;

            case "right":
                col++;
                break;
        }

        boolean inBounds = checkIfInBounds(row, col);
        if (inBounds) {
            matrix[ParisRow][ParisCol] = '-';

            ParisRow = row;
            ParisCol = col;

            char cell = checkCell();

            switch (cell) {
                case 'S':
                    energy -= 2;

                    if (energy <= 0) {
                        matrix[ParisRow][ParisCol] = 'X';
                    } else {
                        matrix[ParisRow][ParisCol] = 'P';
                    }
                    break;

                case 'H':
                    reachedHelen = true;
                    matrix[ParisRow][ParisCol] = '-';
                    break;

                case '-':
                    if (energy > 0) {
                        matrix[ParisRow][ParisCol] = 'P';
                    } else {
                        matrix[ParisRow][ParisCol] = 'X';
                    }
                    break;
            }
        }
    }

    private static char checkCell() {
        return matrix[ParisRow][ParisCol];
    }

    private static boolean checkIfInBounds(int row, int col) {
        return (row >= 0) && (row < matrix.length) &&
                (col >= 0) && (col < matrix[row].length);
    }

    private static void findParis() {
        boolean hasBeenFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] == 'P') {
                    ParisRow = row;
                    ParisCol = col;

                    hasBeenFound = true;
                    break;
                }
            }

            if (hasBeenFound) {
                break;
            }
        }
    }

    private static void readMatrix(int rows, Scanner scanner) {
        matrix = new char[rows][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readElements(scanner);
        }
    }

    private static char[] readElements(Scanner scanner) {
        return scanner.nextLine().toCharArray();
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