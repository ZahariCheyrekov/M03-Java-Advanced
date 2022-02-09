package M03_JavaAdvanced.ExamPreparation.Exam14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class T01Bouquets {
    private static int bouquets;
    private static int storedFlowers;

    private static final int BOUQUETS_TO_MAKE = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] daffodils = readData(scanner);
        ArrayDeque<Integer> daffodilsStack = fillStack(daffodils);

        int[] tulips = readData(scanner);
        ArrayDeque<Integer> tulipsQueue = fillQueue(tulips);

        while (!daffodilsStack.isEmpty() && !tulipsQueue.isEmpty()) {
            int daffodil = daffodilsStack.peek();
            int tulip = tulipsQueue.peek();

            int sum = daffodil + tulip;

            if (sum == 15) {
                bouquets++;
                daffodilsStack.pop();
                tulipsQueue.poll();

            } else if (sum > 15) {
                int valueTulip = tulip;

                while (sum > 15) {
                    valueTulip -= 2;
                    sum = valueTulip + daffodil;

                    if (sum == 15) {
                        bouquets++;

                        tulipsQueue.pop();
                        daffodilsStack.poll();
                    }
                }
            }

            if (sum < 15) {
                storedFlowers += sum;
                daffodilsStack.pop();
                tulipsQueue.poll();
            }
        }

        bouquets += storedFlowers / 15;

        if (bouquets >= BOUQUETS_TO_MAKE) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.%n", BOUQUETS_TO_MAKE - bouquets);
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
