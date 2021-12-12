package M03_JavaAdvanced.L03_SetsAndMaps.Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T05PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phoneBook = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String[] data = input.split("-");
            String name = data[0];
            String number = data[1];
            phoneBook.put(name, number);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("stop")) {
            String name = input;
            if (phoneBook.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, phoneBook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }
            input = scanner.nextLine();
        }
    }
}