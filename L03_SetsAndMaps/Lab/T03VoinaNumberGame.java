package M03_JavaAdvanced.L03_SetsAndMaps.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class T03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rounds = 50;

        LinkedHashSet<Integer> firstPlayerCards = readElements(scanner.nextLine());
        LinkedHashSet<Integer> secondPlayerCards = readElements(scanner.nextLine());

        while (rounds-- > 0) {
            int firstCard = getFirstCard(firstPlayerCards);
            int secondCard = getFirstCard(secondPlayerCards);
            firstPlayerCards.remove(firstCard);
            secondPlayerCards.remove(secondCard);

            if (firstCard > secondCard) {
                firstPlayerCards.add(firstCard);
                firstPlayerCards.add(secondCard);

            } else if (secondCard > firstCard) {
                secondPlayerCards.add(firstCard);
                secondPlayerCards.add(secondCard);
            }

            if (firstPlayerCards.isEmpty() || secondPlayerCards.isEmpty()) {
                break;
            }
        }

        if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerCards.size() > firstPlayerCards.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static int getFirstCard(LinkedHashSet<Integer> set) {
        return set.stream().findFirst().orElse(0);
    }

    private static LinkedHashSet<Integer> readElements(String nextLine) {
        return Arrays.stream(nextLine.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}