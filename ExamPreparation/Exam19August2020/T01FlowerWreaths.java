package M03_JavaAdvanced.ExamPreparation.Exam19August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class T01FlowerWreaths {
    public static int wreaths;
    public static int storedFlowers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] lilies = readData(scanner);
        ArrayDeque<Integer> liliesStack = fillStack(lilies);

        int[] roses = readData(scanner);
        ArrayDeque<Integer> rosesQueue = fillQueue(roses);

        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            int lili = liliesStack.peek();
            int rose = rosesQueue.peek();

            int sum = lili + rose;

            if (sum == 15) {
                wreaths++;
                liliesStack.pop();
                rosesQueue.poll();

            } else if (sum > 15) {
                int liliesCurrent = liliesStack.pop() - 2;
                liliesStack.push(liliesCurrent);

            } else {
                storedFlowers += sum;
                liliesStack.pop();
                rosesQueue.poll();
            }
        }

        wreaths += storedFlowers / 15;

        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n",
                    wreaths);

        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - wreaths);
        }
    }

    private static ArrayDeque<Integer> fillStack(int[] lilies) {
        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();

        for (int num : lilies) {
            liliesStack.push(num);
        }

        return liliesStack;
    }

    private static ArrayDeque<Integer> fillQueue(int[] roses) {
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();

        for (int rose : roses) {
            rosesQueue.offer(rose);
        }

        return rosesQueue;
    }

    private static int[] readData(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("[,\\s]+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}