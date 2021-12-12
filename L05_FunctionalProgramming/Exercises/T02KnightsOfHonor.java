package M03_JavaAdvanced.L05_FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class T02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");

        Consumer<String> addStr = str -> System.out.println("Sir " + str);

        Arrays.stream(names).forEach(addStr);
    }
}