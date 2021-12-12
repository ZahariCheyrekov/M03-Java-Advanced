package M03_JavaAdvanced.L03_SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class T07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> peopleData = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();
            int firstIndex = email.lastIndexOf(".");
            String emailExtension = email.substring(firstIndex + 1).toLowerCase();

            if (!emailExtension.equals("us") && !emailExtension.equals("uk") && !emailExtension.equals("com")) {
                peopleData.put(name, email);
            }
            input = scanner.nextLine();
        }
        peopleData.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
    }
}