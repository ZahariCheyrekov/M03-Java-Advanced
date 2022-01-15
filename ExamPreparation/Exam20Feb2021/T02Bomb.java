package M03_JavaAdvanced.ExamPreparation.Exam20Feb2021;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class T02Bomb {
    public static char[][] field;

    public static int sapperRow;
    public static int sapperCol;

    public static int allBombs = 0;
    public static int foundBombs = 0;

    public static boolean foundEnd = false;
    public static boolean foundAllBombs = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        field = new char[size][size];

        String[] directions = scanner.nextLine().split("[,\\s]+");
        ArrayDeque<String> allDirections = new ArrayDeque<>();

        Collections.addAll(allDirections, directions);

        readField(scanner);

        while (!allDirections.isEmpty()) {
            String direction = allDirections.poll();

            field[sapperRow][sapperCol] = '+';
            moveSapper(direction);

            if (allDirections.isEmpty()) {
                break;
            }

            if (foundEnd) {
                break;
            }

            if (foundAllBombs) {
                break;
            }
        }

        if (foundAllBombs) {
            System.out.println("Congratulations! You found all bombs!");

        } else if (foundEnd) {
            System.out.printf("END! %d bombs left on the field%n", allBombs - foundBombs);

        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n",
                    allBombs - foundBombs, sapperRow, sapperCol);
        }
    }

    private static void moveSapper(String direction) {
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
            char currentCell = field[row][col];

            switch (currentCell) {
                case 'B':
                    System.out.println("You found a bomb!");
                    foundBombs++;

                    if (foundBombs == allBombs) {
                        foundAllBombs = true;
                    }
                    break;

                case 'e':
                    foundEnd = true;
                    break;
            }

            sapperRow = row;
            sapperCol = col;
        }

        field[sapperRow][sapperCol] = 's';
    }

    private static boolean checkIfInBounds(int row, int col) {
        return (row >= 0) && (row < field.length) &&
                (col >= 0) && (col < field[row].length);
    }

    private static void readField(Scanner scanner) {
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