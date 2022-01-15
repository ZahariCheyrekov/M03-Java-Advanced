package M03_JavaAdvanced.ExamPreparation.Exam26June2021;

import java.util.*;

public class T02Python {
    public static char[][] screen;

    public static int snakeRow;
    public static int snakeCol;

    public static int snakeLength = 1;

    public static int allFood;
    public static int foodEaten;

    public static List<String> commands = new ArrayList<>();

    public static boolean killedByEnemy = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        screen = new char[size][size];

        readCommands(scanner);

        readScreen(scanner);

        while (!commands.isEmpty()) {
            String direction = commands.remove(0);

            screen[snakeRow][snakeCol] = '*';
            moveSnake(direction);

            if (killedByEnemy) {
                break;
            }

            if (foodEaten == allFood) {
                break;
            }
        }

        if (killedByEnemy) {
            System.out.println("You lose! Killed by an enemy!");

        } else if (foodEaten == allFood) {
            System.out.printf("You win! Final python length is %s%n", snakeLength);

        } else {
            System.out.printf("You lose! There is still %d food to be eaten.%n", allFood - foodEaten);
        }

    }

    private static void moveSnake(String direction) {
        int row = snakeRow;
        int col = snakeCol;

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
            char currentCell = screen[row][col];

            switch (currentCell) {
                case 'e':
                    killedByEnemy = true;
                    break;

                case 'f':
                    snakeLength++;
                    foodEaten++;
                    break;
            }

        } else {
            if (row >= screen.length) {
                row = 0;
            } else if (row < 0) {
                row = screen.length - 1;
            }

            if (col >= screen[row].length) {
                col = 0;
            } else if (col < 0) {
                col = screen[row].length - 1;
            }

            char currentCell = screen[row][col];

            if (currentCell == 'f') {
                snakeLength++;
                foodEaten++;
            }

            if (currentCell == 'e') {
                killedByEnemy = true;
            }
        }

        snakeRow = row;
        snakeCol = col;

        screen[snakeRow][snakeCol] = 's';
    }

    private static boolean checkIfInBounds(int row, int col) {
        return (row >= 0) && (row < screen.length) &&
                (col >= 0) && (col < screen[row].length);
    }

    private static void readScreen(Scanner scanner) {
        for (int row = 0; row < screen.length; row++) {
            String[] elements = scanner.nextLine().split("[\\s]+");

            for (int col = 0; col < elements.length; col++) {
                char currentCell = elements[col].charAt(0);

                if (currentCell == 's') {
                    snakeRow = row;
                    snakeCol = col;
                }

                if (currentCell == 'f') {
                    allFood++;
                }

                screen[row][col] = currentCell;
            }
        }
    }

    private static void readCommands(Scanner scanner) {
        String[] directions = scanner.nextLine().split("[,\\s]+");
        commands.addAll(Arrays.asList(directions));
    }
}