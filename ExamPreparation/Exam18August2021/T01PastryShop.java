package M03_JavaAdvanced.ExamPreparation.Exam18August2021;

import java.util.*;

public class T01PastryShop {
    public static Map<String, Integer> craftedItems = new LinkedHashMap<>();

    private static int biscuits = 0;
    private static int cakes = 0;
    private static int pastries = 0;
    private static int pies = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] liquids = readData(scanner);
        ArrayDeque<Integer> liquidsQueue = fillQueue(liquids);

        int[] ingredients = readData(scanner);
        ArrayDeque<Integer> ingredientsStack = fillStack(ingredients);

        craftedItems.put("Biscuit", 0);
        craftedItems.put("Cake", 0);
        craftedItems.put("Pie", 0);
        craftedItems.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquid = liquidsQueue.peek();
            int ingredient = ingredientsStack.peek();

            int sum = liquid + ingredient;

            String product = null;
            boolean crafted = false;

            switch (sum) {
                case 25:
                    product = "Biscuit";
                    biscuits++;
                    crafted = true;
                    break;
                case 50:
                    product = "Cake";
                    cakes++;
                    crafted = true;
                    break;
                case 75:
                    product = "Pastry";
                    pastries++;
                    crafted = true;
                    break;
                case 100:
                    product = "Pie";
                    pies++;
                    crafted = true;
                    break;
            }

            if (crafted) {
                craftedItems.put(product, craftedItems.get(product) + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();

            } else {
                liquidsQueue.poll();
                int currentIngredient = ingredientsStack.pop() + 3;
                ingredientsStack.push(currentIngredient);
            }
        }

        boolean succeeded = biscuits >= 1 && cakes >= 1 && pastries >= 1 && pies >= 1;

        if (succeeded) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
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
