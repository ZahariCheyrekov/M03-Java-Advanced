package M03_JavaAdvanced.ExamPreparation.Exam16Dec2020;

import java.util.*;

public class T01Cooking {

    public static Map<String, Integer> craftedItems = new TreeMap<>();

    public static int breads = 0;
    public static int cakes = 0;
    public static int pastries = 0;
    public static int pies = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        craftedItems.put("Bread", 0);
        craftedItems.put("Cake", 0);
        craftedItems.put("Pastry", 0);
        craftedItems.put("Fruit Pie", 0);

        int[] liquids = readData(scanner);
        ArrayDeque<Integer> liquidsQueue = fillQueue(liquids);

        int[] ingredients = readData(scanner);
        ArrayDeque<Integer> ingredientsStack = fillStack(ingredients);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquid = liquidsQueue.peek();
            int ingredient = ingredientsStack.peek();

            int sum = liquid + ingredient;

            String product = null;
            boolean crafted = false;

            switch (sum) {
                case 25:
                    product = "Bread";
                    crafted = true;
                    breads++;
                    break;

                case 50:
                    product = "Cake";
                    crafted = true;
                    cakes++;
                    break;

                case 75:
                    product = "Pastry";
                    crafted = true;
                    pastries++;
                    break;

                case 100:
                    product = "Fruit Pie";
                    crafted = true;
                    pies++;
                    break;

                default:
                    liquidsQueue.poll();
                    int valueIngredient = ingredientsStack.pop() + 3;
                    ingredientsStack.push(valueIngredient);
                    break;
            }

            if (crafted) {
                liquidsQueue.poll();
                ingredientsStack.pop();
            }

            if (product != null) {
                craftedItems.put(product, craftedItems.get(product) + 1);
            }
        }

        boolean succeeded = (breads >= 1) && (cakes >= 1) &&
                (pastries >= 1) && (pies >= 1);

        if (succeeded) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");

        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");

        } else {
            System.out.print("Liquids left: ");
            System.out.println(liquidsQueue.toString()
                    .replaceAll("[\\[\\]]", ""));
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");

        } else {
            System.out.print("Ingredients left: ");
            System.out.println(ingredientsStack.toString()
                    .replaceAll("[\\[\\]]", ""));
        }

        craftedItems.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }

    private static ArrayDeque<Integer> fillQueue(int[] liquids) {
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();

        for (int liquid : liquids) {
            liquidsQueue.offer(liquid);
        }

        return liquidsQueue;
    }

    private static ArrayDeque<Integer> fillStack(int[] ingredients) {
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        for (int ingredient : ingredients) {
            ingredientsStack.push(ingredient);
        }

        return ingredientsStack;
    }

    private static int[] readData(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}