package M03_JavaAdvanced.ExamPreparation.Exam20Feb2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class T01MagicBox {
    private static Scanner scanner;

    private static int claimedItems;
    private static final int NEEDED_SUM = 90;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstMagiBox = fillQueue();
        ArrayDeque<Integer> secondMagicBox = fillStack();

        while (!firstMagiBox.isEmpty() && !secondMagicBox.isEmpty()) {
            int first = firstMagiBox.peek();
            int second = secondMagicBox.peek();

            int result = first + second;

            if (result % 2 == 0) {

                claimedItems += result;
                firstMagiBox.poll();
                secondMagicBox.pop();

            } else {
                int lastSecond = secondMagicBox.pop();
                firstMagiBox.offer(lastSecond);
            }
        }

        if (firstMagiBox.isEmpty()) {
            System.out.println("First magic box is empty.");

        } else {
            System.out.println("Second magic box is empty.");
        }

        if (claimedItems >= NEEDED_SUM) {
            System.out.printf("Wow, your prey was epic! Value: %d%n", claimedItems);
        } else {
            System.out.printf("Poor prey... Value: %d%n", claimedItems);
        }
    }

    private static ArrayDeque<Integer> fillQueue() {
        int[] numbers = readData(scanner);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int box : numbers) {
            queue.offer(box);
        }

        return queue;
    }

    private static ArrayDeque<Integer> fillStack() {
        int[] numbers = readData(scanner);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int box : numbers) {
            stack.push(box);
        }

        return stack;
    }

    private static int[] readData(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
