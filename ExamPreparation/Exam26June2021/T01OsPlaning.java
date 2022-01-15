package M03_JavaAdvanced.ExamPreparation.Exam26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class T01OsPlaning {
    public static boolean finishedTask = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] values = readData(scanner);
        ArrayDeque<Integer> valuesStack = fillStack(values);

        int[] threads = readData(scanner);
        ArrayDeque<Integer> threadsQueue = fillQueue(threads);

        int taskValue = Integer.parseInt(scanner.nextLine());

        while (!finishedTask) {
            if (valuesStack.isEmpty() || threadsQueue.isEmpty()) {
                break;
            }

            int value = valuesStack.peek();
            int thread = threadsQueue.peek();

            if (value == taskValue) {
                System.out.printf("Thread with value %d killed task %d%n", thread, value);
                finishedTask = true;
                continue;
            }

            if (thread >= value) {
                valuesStack.pop();
                threadsQueue.poll();
            }

            if (thread < value) {
                threadsQueue.poll();
            }
        }

        for (int thread : threadsQueue) {
            System.out.print(thread + " ");
        }
        System.out.println();
    }

    private static ArrayDeque<Integer> fillQueue(int[] threads) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int num : threads) {
            queue.offer(num);
        }

        return queue;
    }

    private static ArrayDeque<Integer> fillStack(int[] values) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int num : values) {
            stack.push(num);
        }

        return stack;
    }

    private static int[] readData(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split("[,\\s]+")).mapToInt(Integer::parseInt).toArray();
    }
}