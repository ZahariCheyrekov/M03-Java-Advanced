package M03_JavaAdvanced.L02_MultidimensionalArrays.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T12TheMatrix {
    public static char[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = readData(reader);

        int rows = dimensions[0];
        int cols = dimensions[1];

        matrix = new char[rows][cols];
        fillMatrix(reader);

        char fillChar = reader.readLine().charAt(0);

        int[] startPosition = readData(reader);

        int startRow = startPosition[0];
        int startCol = startPosition[1];

        char charToReplace = matrix[startRow][startCol];

        replaceChars(charToReplace, fillChar, startRow, startCol);

        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    private static void replaceChars(char charToReplace, char fillChar, int row, int col) {
        if (!isValid(row, col, charToReplace)) {
            return;
        }

        matrix[row][col] = fillChar;

        replaceChars(charToReplace, fillChar, row - 1, col);
        replaceChars(charToReplace, fillChar, row + 1, col);
        replaceChars(charToReplace, fillChar, row, col - 1);
        replaceChars(charToReplace, fillChar, row, col + 1);
    }

    private static boolean isValid(int row, int col, char charToReplace) {
        return (row >= 0) && (row < matrix.length) &&
                (col >= 0) && col < (matrix[row].length) &&
                (matrix[row][col] == charToReplace);
    }

    private static void fillMatrix(BufferedReader reader) throws IOException {
        for (int row = 0; row < matrix.length; row++) {
            String[] line = reader.readLine().split("\\s+");
            for (int col = 0; col < line.length; col++) {
                matrix[row][col] = line[col].charAt(0);
            }
        }
    }

    private static int[] readData(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}