package M03_JavaAdvanced.ExamPreparation.Exam20Feb2021;

import java.util.*;

public class T02Bomb {
    public static char[][] field;

    public static int sapperRow;
    public static int sapperCol;

    public static int allBombs;
    public static int foundBombs;

    public static boolean foundEnd;
    public static boolean foundAllBombs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        field = new char[size][size];

        String[] commands = scanner.nextLine().split("[,\\s]+");

        readField(scanner);

        int index = 0;
        while (index < commands.length) {
            String direction = commands[index++];

            field[sapperRow][sapperCol] = '+';
            moveSapper(direction);

            if (foundAllBombs) {
                System.out.println("Congratulations! You found all bombs!");
                break;
            }

            if (foundEnd) {
                System.out.printf("END! %d bombs left on the field%n", allBombs - foundBombs);
                break;
            }
        }

        if (!foundEnd && !foundAllBombs) {
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
                case 'e':
                    foundEnd = true;
                    break;

                case 'B':
                    System.out.println("You found a bomb!");

                    foundBombs++;

                    if (foundBombs >= allBombs) {
                        foundAllBombs = true;
                    }
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
