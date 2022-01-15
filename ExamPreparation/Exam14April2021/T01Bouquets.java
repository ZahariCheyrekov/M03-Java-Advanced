package M03_JavaAdvanced.ExamPreparation.Exam14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class T01Bouquets {
    public static int bouquets = 0;
    public static int storedFlowers = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tulips = readData(scanner);
        ArrayDeque<Integer> tulipsStack = fillStack(tulips);

        int[] daffodils = readData(scanner);
        ArrayDeque<Integer> daffodilsQueue = fillQueue(daffodils);

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int tulip = tulipsStack.peek();
            int daffodil = daffodilsQueue.peek();

            int sum = daffodil + tulip;

            if (sum == 15) {
                bouquets++;

                tulipsStack.pop();
                daffodilsQueue.poll();

            } else if (sum > 15) {
                int valueTulip = tulip;

                while (sum > 15) {
                    valueTulip -= 2;
                    sum = valueTulip + daffodil;

                    if (sum == 15) {
                        bouquets++;

                        tulipsStack.pop();
                        daffodilsQueue.poll();
                    }
                }

            }

            if (sum < 15) {
                storedFlowers += sum;

                tulipsStack.pop();
                daffodilsQueue.poll();
            }
        }

        bouquets += storedFlowers / 15;

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);

        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }

    private static ArrayDeque<Integer> fillQueue(int[] tulips) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int num : tulips) {
            queue.offer(num);
        }

        return queue;
    }

    private static ArrayDeque<Integer> fillStack(int[] daffodils) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int num : daffodils) {
            stack.push(num);
        }

        return stack;
    }

    private static int[] readData(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split("[,\\s]+")).mapToInt(Integer::parseInt).toArray();
    }
}