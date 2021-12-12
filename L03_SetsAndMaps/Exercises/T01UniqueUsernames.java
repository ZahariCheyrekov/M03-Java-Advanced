package M03_JavaAdvanced.L03_SetsAndMaps.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class T01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new LinkedHashSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            set.add(text);
        }
        System.out.println(String.join(System.lineSeparator(), set));
    }
}