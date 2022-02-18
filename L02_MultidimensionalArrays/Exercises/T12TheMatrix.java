package M03_JavaAdvanced.L02_MultidimensionalArrays.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T12TheMatrix {
    private static char[][] matrix;

    private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] dimensions = readData();

        int rows = dimensions[0];
        int cols = dimensions[1];

        matrix = new char[rows][cols];
        fillMatrix();

        char fillChar = reader.readLine().charAt(0);

        int[] startPosition = readData();

        int startRow = startPosition[0];
        int startCol = startPosition[1];

        char charToReplace = matrix[startRow][startCol];

        replaceChars(charToReplace, fillChar, startRow, startCol);

        printMatrix();
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
                (col >= 0) && (col < matrix[row].length) &&
                (matrix[row][col] == charToReplace);
    }

    private static void fillMatrix() throws IOException {
        for (int row = 0; row < matrix.length; row++) {
            String[] line = reader.readLine().split("\\s+");
           
            for (int col = 0; col < line.length; col++) {
                matrix[row][col] = line[col].charAt(0);
            }
        }
    }

    private static int[] readData() throws IOException {
        return Arrays.stream(reader.readLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static void printMatrix() {
        StringBuilder output = new StringBuilder();

        for (char[] row : matrix) {
            for (char col : row) {
                output.append(col);
            }
            output.append(System.lineSeparator());
        }

        System.out.print(output);
    }
}
