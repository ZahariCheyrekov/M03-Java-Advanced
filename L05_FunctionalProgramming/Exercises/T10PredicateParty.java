package M03_JavaAdvanced.L05_FunctionalProgramming.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class T10PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        List<String> guests = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        input = reader.readLine();
        while (!input.equals("Party!")) {
            String[] commandTokens = input.split("\\s+");

            String command = commandTokens[0];
            String predicateType = commandTokens[1];
            String predicateArgument = commandTokens[2];

            if (command.equals("Remove")) {
                guests.removeIf(getPredicate(predicateType, predicateArgument));
            } else if (command.equals("Double")) {

                for (int i = 0; i < guests.size(); i++) {
                    String guest = guests.get(i);
                    if (getPredicate(predicateType, predicateArgument).test(guest)) {
                        guests.add(i++, guest);
                    }
                }
            }
            input = reader.readLine();
        }

        if (guests.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(guests);
            System.out.printf("%s are going to the party!%n", String.join(", ", guests));
        }
    }

    private static Predicate<String> getPredicate(String type, String parameter) {
        switch (type) {
            case "StartsWith":
                return text -> text.startsWith(parameter);
            case "EndsWith":
                return text -> text.endsWith(parameter);
            case "Length":
                return text -> text.length() == Integer.parseInt(parameter);
            default:
                return text -> false;
        }
    }
}