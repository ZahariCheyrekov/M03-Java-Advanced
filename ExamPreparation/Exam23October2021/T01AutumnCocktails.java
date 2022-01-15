package M03_JavaAdvanced.ExamPreparation.Exam23October2021;

import java.util.*;

public class T01AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ingredients = readElements(scanner);

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        for (int material : ingredients) {
            ingredientsQueue.offer(material);
        }

        int[] freshnessNumbers = readElements(scanner);

        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        for (int magic : freshnessNumbers) {
            freshnessStack.push(magic);
        }

        Map<String, Integer> cocktails = new TreeMap<>();

        int pearSour = 0;
        int theHarvest = 0;
        int appleHinny = 0;
        int highFashion = 0;

        while (ingredientsQueue.size() > 0 && freshnessStack.size() > 0) {
            int ingredient = ingredientsQueue.peek();
            int freshness = freshnessStack.peek();

            int product = freshness * ingredient;

            if (ingredient == 0) {
                ingredientsQueue.poll();

            } else if (product == 150 || product == 250 || product == 300 || product == 400) {
                String gift;
                if (product == 150) {
                    pearSour++;
                    gift = "Pear Sour";

                } else if (product == 250) {
                    theHarvest++;
                    gift = "The Harvest";

                } else if (product == 300) {
                    appleHinny++;
                    gift = "Apple Hinny";

                } else {
                    highFashion++;
                    gift = "High Fashion";
                }

                ingredientsQueue.poll();
                freshnessStack.pop();

                cocktails.putIfAbsent(gift, 0);
                cocktails.put(gift, cocktails.get(gift) + 1);

            } else {
                freshnessStack.pop();
                int ingredientNum = ingredientsQueue.poll() + 5;

                ingredientsQueue.offer(ingredientNum);
            }
        }

        boolean craftedPresents = ((pearSour >= 1) && (theHarvest >= 1) &&
                (appleHinny >= 1) && (highFashion >= 1));

        if (craftedPresents) {
            System.out.println("It's party time! The cocktails are ready!");

        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int sumIngredients = ingredientsQueue.stream().mapToInt(i -> i).sum();

        if (!ingredientsQueue.isEmpty()) {
            System.out.println("Ingredients left: " + sumIngredients);
        }

        cocktails.forEach((key, value) -> System.out.printf(" # %s --> %d%n", key, value));
    }

    private static int[] readElements(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}