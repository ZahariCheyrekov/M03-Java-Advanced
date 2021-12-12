package M03_JavaAdvanced.L02_MultidimensionalArrays.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class T11ReverseMatrixDiagonals {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String[] dimensions = reader.readLine().trim().split("\\s+");
        final int rows = Integer.parseInt(dimensions[0]);
        final int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(reader.readLine().trim().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        Map<Integer, List<Integer>> diagonals = new LinkedHashMap<>();
        for (int group = 0, diagonal = 0, row = rows - 1; row >= 0; row--, diagonal = ++group) {
            for (int col = cols - 1; col >= 0 && col >= group; col--, diagonal++) {
                addValueToDiagonal(diagonals, matrix[row][col], diagonal);
            }

            for (int r = rows - 1 - 1 - group; r >= 0 && group < cols; r--, diagonal++) {
                addValueToDiagonal(diagonals, matrix[r][group], diagonal);
            }
        }

        final StringBuilder sb = new StringBuilder();

        diagonals.values().forEach(numbers -> sb
                .append(numbers.stream().map(Object::toString).collect(Collectors.joining(" ")))
                .append(System.lineSeparator()));

        System.out.print(sb);
    }

    private static void addValueToDiagonal(Map<Integer, List<Integer>> diagonals, int value, int diagonal) {
        diagonals.putIfAbsent(diagonal, new ArrayList<>());
        diagonals.get(diagonal).add(value);
    }
}