package M03_JavaAdvanced.L05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class T03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> startsWIthCapitalLetter = str -> Character.isUpperCase(str.charAt(0));

        String[] words = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(startsWIthCapitalLetter)
                .toArray(String[]::new);

        System.out.println(words.length);

        Arrays.stream(words).forEach(System.out::println);
    }
}