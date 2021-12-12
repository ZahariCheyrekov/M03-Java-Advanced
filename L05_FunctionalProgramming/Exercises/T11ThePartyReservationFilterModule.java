package M03_JavaAdvanced.L05_FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class T11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        if (input.length() == 0) {
            return;
        }

        List<String> names = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());

        input = scanner.nextLine();
        List<String> commandLines = new ArrayList<>();

        while (!input.equals("Print")) {
            String[] lineParts = input.split(";");
            String commands = lineParts[0];
            String type = lineParts[1];
            String toCheck = lineParts[2];

            if (commands.equals("Add filter")) {
                commandLines.add(input);
            } else if (commands.equals("Remove filter")) {
                String commandToRemove = "Add filter;" + type + ";" + toCheck;
                commandLines.removeIf(s -> s.equals(commandToRemove));
            }
            input = scanner.nextLine();
        }
        for (String command : commandLines) {
            String[] lineParts = command.split(";");
            String type = lineParts[1];
            String toCheck = lineParts[2];

            Predicate<String> startsWith = name -> name.startsWith(toCheck);
            Predicate<String> endsWith = name -> name.endsWith(toCheck);
            Predicate<String> validLenght = name -> name.length() == Integer.parseInt(toCheck);
            Predicate<String> containsLetter = name -> name.contains(toCheck);

            switch (type) {
                case "Starts with":
                    names.removeIf(startsWith);
                    break;
                case "Ends with":
                    names.removeIf(endsWith);
                    break;
                case "Length":
                    names.removeIf(validLenght);
                    break;
                case "Contains":
                    names.removeIf(containsLetter);
                    break;
            }
        }
        System.out.println(String.join(" ", names).replaceAll("([\\[\\]])", ""));
    }
}
