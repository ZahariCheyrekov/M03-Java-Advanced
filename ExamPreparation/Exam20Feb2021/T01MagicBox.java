package M03_JavaAdvanced.ExamPreparation.Exam20Feb2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class T01MagicBox {
    public static int claimedItems = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstMagicBox = readData(scanner);
        ArrayDeque<Integer> boxQueue = fillQueue(firstMagicBox);

        int[] secondMagicBox = readData(scanner);
        ArrayDeque<Integer> boxStack = fillStack(secondMagicBox);

        while (!boxQueue.isEmpty() && !boxStack.isEmpty()) {
            int firstBox = boxQueue.peek();
            int secondBox = boxStack.peek();

            int sum = firstBox + secondBox;

            if (sum % 2 == 0) {
                claimedItems += sum;

                boxQueue.poll();
                boxStack.pop();

            } else {
                int lastItemSecondBox = boxStack.pop();
                boxQueue.offer(lastItemSecondBox);
            }
        }

        if (boxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");

        } else {
            System.out.println("Second magic box is empty.");
        }

        if (claimedItems >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d%n", claimedItems);

        } else {
            System.out.printf("Poor prey... Value: %d%n", claimedItems);
        }
    }

    private static ArrayDeque<Integer> fillQueue(int[] firstMagicBox) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int box : firstMagicBox) {
            queue.offer(box);
        }

        return queue;
    }

    private static ArrayDeque<Integer> fillStack(int[] secondMagicBox) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int box : secondMagicBox) {
            stack.push(box);
        }

        return stack;
    }

    private static int[] readData(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}