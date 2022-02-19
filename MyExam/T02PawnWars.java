package M03_JavaAdvanced.ExamPreparation.MyExam;

import java.util.Scanner;

public class T02PawnWars {
    private static final Scanner scanner = new Scanner(System.in);

    private static final char[][] board = new char[8][8];
    private static final String[][] exampleBoard = {
            {"a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"},
            {"a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"},
            {"a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6"},
            {"a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5"},
            {"a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4"},
            {"a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3"},
            {"a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"},
            {"a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"},};

    private static int blackPawnRow;
    private static int blackPawnCol;

    private static int whitePawnRow;
    private static int whitePawnCol;

    private static boolean gameEnded;

    public static void main(String[] args) {
        readBoard();

        findPawnPositions();

        int move = 0;
        while (!gameEnded) {

            if (move % 2 == 0) {
                if (blackPawnRow == whitePawnRow - 1 && (blackPawnCol == whitePawnCol - 1 ||
                        blackPawnCol == whitePawnCol + 1)) {

                    String position = getPosition(blackPawnRow, blackPawnCol);
                    System.out.printf("Game over! White capture on %s.%n", position);

                    gameEnded = true;
                }

                if (!gameEnded) {
                    board[whitePawnRow][whitePawnCol] = '-';
                    whitePawnRow--;
                    board[whitePawnRow][whitePawnCol] = 'w';
                }

            } else {

                if (whitePawnRow == blackPawnRow + 1 && (whitePawnCol == blackPawnCol - 1 ||
                        whitePawnCol == blackPawnCol + 1)) {

                    String position = getPosition(whitePawnRow, whitePawnCol);
                    System.out.printf("Game over! Black capture on %s.%n", position);

                    gameEnded = true;
                }

                if (!gameEnded) {
                    board[blackPawnRow][blackPawnCol] = '-';
                    blackPawnRow++;
                    board[blackPawnRow][blackPawnCol] = 'b';
                }
            }

            if (whitePawnRow == 0) {
                String position = getPosition(whitePawnRow, whitePawnCol);
                System.out.printf("Game over! White pawn is promoted to a queen at %s.%n", position);
                gameEnded = true;
            }

            if (blackPawnRow == 7) {
                String position = getPosition(blackPawnRow, blackPawnCol);
                System.out.printf("Game over! Black pawn is promoted to a queen at %s.%n", position);
                gameEnded = true;
            }

            move++;
        }
    }

    private static String getPosition(int rowPawn, int colPawn) {
        return exampleBoard[rowPawn][colPawn];
    }

    private static void findPawnPositions() {
        boolean foundWhitePawn = false;
        boolean foundBlackPawn = false;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char currentChar = board[row][col];

                if (currentChar == 'w') {
                    whitePawnRow = row;
                    whitePawnCol = col;

                    foundWhitePawn = true;
                }

                if (currentChar == 'b') {
                    blackPawnRow = row;
                    blackPawnCol = col;

                    foundBlackPawn = true;
                }
            }

            if (foundWhitePawn && foundBlackPawn) {
                break;
            }
        }
    }

    private static void readBoard() {
        for (int row = 0; row < 8; row++) {
            board[row] = scanner.nextLine().toCharArray();
        }
    }
}
