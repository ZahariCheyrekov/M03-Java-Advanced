package M03_JavaAdvanced.L02_MultidimensionalArrays.Exercises;

import java.util.*;

public class T06StringMatrixRotations {
    public static char[][] matrix;

    public static List<String> words = new ArrayList<>();

    public static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int degrees = Integer.parseInt(input.substring(7, input.length() - 1));

        addWords(scanner);

        int maxWordLength = words.stream().mapToInt(String::length).max().getAsInt();
        matrix = new char[words.size()][maxWordLength];
        fillMatrix();

        int numberOfRotations = (degrees / 90) % 4;
        for (int i = 1; i <= numberOfRotations; i++) {
            rotateMatrix();
        }

        printMatrix();
    }

    private static void addWords(Scanner scanner) {
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            words.add(input);
            input = scanner.nextLine();
        }
    }

    private static void rotateMatrix() {
        int rows = words.stream().mapToInt(String::length).max().getAsInt();

        char[][] newMatrix = new char[rows][];

        for (int row = 0; row < newMatrix.length; row++) {
            newMatrix[row] = new char[matrix.length];

            for (int col = 0; col < newMatrix[row].length; col++) {
                newMatrix[row][col] = matrix[matrix.length - 1 - col][row];
            }
        }

        matrix = newMatrix;
    }

    private static void fillMatrix() {
        for (int row = 0; row < words.size(); row++) {
            int count = 0;

            String currentWord = words.get(row);
            for (int i = 0; i < currentWord.length(); i++) {
                matrix[row][count++] = currentWord.charAt(i);
            }
        }
    }

    private static void printMatrix() {
        for (char[] row : matrix) {
            for (char col : row) {
                output.append(col);
            }
            output.append(System.lineSeparator());
        }

        System.out.print(output);
    }
}