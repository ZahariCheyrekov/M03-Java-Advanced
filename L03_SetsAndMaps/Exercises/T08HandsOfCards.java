package M03_JavaAdvanced.L03_SetsAndMaps.Exercises;

import java.util.*;

public class T08HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> players = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String name = input.split(": ")[0];
            String[] inputCards = input.split(": ")[1].split(", ");

            Set<String> cards = new HashSet<>();
            Collections.addAll(cards, inputCards);

            if (!players.containsKey(name)) {
                players.put(name, cards);
            } else {
                Set<String> currentCards = players.get(name);
                currentCards.addAll(cards);
                players.put(name, currentCards);
            }
            input = scanner.nextLine();
        }

        for (var player : players.entrySet()) {
            int points = getPointsPlayer(player.getValue());
            System.out.println(player.getKey() + ": " + points);
        }
    }

    private static int getPointsPlayer(Set<String> cards) {
        int sumPoints = 0;
        Map<Character, Integer> pointsValues = getPointsValue();

        for (String card : cards) {
            if (card.contains("10")) {
                char strength = card.charAt(2);
                sumPoints += 10 * pointsValues.get(strength);
            } else {
                char number = card.charAt(0);
                char strength = card.charAt(1);

                sumPoints += pointsValues.get(strength) * pointsValues.get(number);
            }
        }
        return sumPoints;
    }

    private static Map<Character, Integer> getPointsValue() {
        Map<Character, Integer> points = new HashMap<>();
        points.put('2', 2);
        points.put('3', 3);
        points.put('4', 4);
        points.put('5', 5);
        points.put('6', 6);
        points.put('7', 7);
        points.put('8', 8);
        points.put('9', 9);
        points.put('J', 11);
        points.put('Q', 12);
        points.put('K', 13);
        points.put('A', 14);

        points.put('S', 4);
        points.put('H', 3);
        points.put('D', 2);
        points.put('C', 1);

        return points;
    }
}