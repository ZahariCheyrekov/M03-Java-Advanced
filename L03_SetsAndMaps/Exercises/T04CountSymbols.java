package M03_JavaAdvanced.L03_SetsAndMaps.Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class T04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> counts = new TreeMap<>();

        String input = scanner.nextLine();
        for (int symbol = 0; symbol < input.length(); symbol++) {
            char currentChar = input.charAt(symbol);
            counts.putIfAbsent(currentChar, 0);
            counts.put(currentChar, counts.get(currentChar) + 1);
        }
        counts.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));
    }
}