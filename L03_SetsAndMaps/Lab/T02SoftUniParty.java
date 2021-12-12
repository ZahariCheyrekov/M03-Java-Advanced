package M03_JavaAdvanced.L03_SetsAndMaps.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class T02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> VIP = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String input = scanner.nextLine();
        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                VIP.add(input);
            } else {
                regular.add(input);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("END")) {
            VIP.remove(input);
            regular.remove(input);
            input = scanner.nextLine();
        }

        System.out.println(VIP.size() + regular.size());
        if (!VIP.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), VIP));
        }
        if (!regular.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), regular));
        }
    }
}