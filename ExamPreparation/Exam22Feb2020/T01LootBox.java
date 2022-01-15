package M03_JavaAdvanced.ExamPreparation.Exam22Feb2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class T01LootBox {
    public static int[] first;
    public static int[] second;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        first = readData(scanner);
        ArrayDeque<Integer> firstLootBox = new ArrayDeque<>();
        fillFirst(firstLootBox);

        second = readData(scanner);
        ArrayDeque<Integer> secondLootBox = new ArrayDeque<>();
        fillSecond(secondLootBox);

        int sumClaimedItems = 0;
        while (!firstLootBox.isEmpty() || !secondLootBox.isEmpty()) {
            if (firstLootBox.isEmpty()) {
                System.out.println("First lootbox is empty");
                break;
            } else if (secondLootBox.isEmpty()) {
                System.out.println("Second lootbox is empty");
                break;
            }

            int firstNum = firstLootBox.peek();
            int secondNum = secondLootBox.peek();

            int sum = firstNum + secondNum;

            if (sum % 2 == 0) {
                sumClaimedItems += sum;

                firstLootBox.poll();
                secondLootBox.pop();

            } else {
                int removed = secondLootBox.pop();
                firstLootBox.offer(removed);
            }
        }

        if (sumClaimedItems >= 100) {
            System.out.printf("Your loot was epic! Value: %d%n", sumClaimedItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", sumClaimedItems);
        }

    }

    private static void fillSecond(ArrayDeque<Integer> secondLootBox) {
        for (int num : second) {
            secondLootBox.push(num);
        }
    }

    private static void fillFirst(ArrayDeque<Integer> firstLootBox) {
        for (int num : first) {
            firstLootBox.offer(num);
        }
    }

    private static int[] readData(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}