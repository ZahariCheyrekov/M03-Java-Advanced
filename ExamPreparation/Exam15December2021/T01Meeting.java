package M03_JavaAdvanced.ExamPreparation.Exam15December2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class T01Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        fillStack(maleStack, scanner);

        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();
        fillQueue(femaleQueue, scanner);

        int matches = 0;
        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {
            int male = maleStack.peek();
            int female = femaleQueue.peek();

            if (female <= 0) {
                femaleQueue.poll();

            } else if (male <= 0) {
                maleStack.pop();

            } else if (female % 25 == 0) {
                femaleQueue.poll();
                femaleQueue.poll();

            } else if (male % 25 == 0) {
                maleStack.pop();
                maleStack.pop();

            } else if (female == male) {
                matches++;
                femaleQueue.poll();
                maleStack.pop();

            } else {
                femaleQueue.poll();
                int malePoints = male - 2;
                maleStack.pop();
                maleStack.push(malePoints);
            }
        }

        System.out.println("Matches: " + matches);

        if (maleStack.isEmpty()) {
            System.out.println("Males left: none");

        } else {
            System.out.print("Males left: ");
            System.out.println(String.join(", ",
                    maleStack.toString()).replaceAll("[\\[\\]]", ""));
        }

        if (femaleQueue.isEmpty()) {
            System.out.println("Females left: none");

        } else {
            System.out.print("Females left: ");
            System.out.println(String.join(", ",
                    femaleQueue.toString()).replaceAll("[\\[\\]]", ""));
        }
    }

    private static void fillStack(ArrayDeque<Integer> maleStack, Scanner scanner) {
        int[] males = Arrays.stream(scanner.nextLine().split("[\\s]+")).mapToInt(Integer::parseInt).toArray();

        for (int m : males) {
            maleStack.push(m);
        }
    }

    private static void fillQueue(ArrayDeque<Integer> femaleQueue, Scanner scanner) {
        int[] females = Arrays.stream(scanner.nextLine().split("[\\s]+")).mapToInt(Integer::parseInt).toArray();

        for (int f : females) {
            femaleQueue.offer(f);
        }
    }
}
