package M03_JavaAdvanced.ExamPreparation.Exam26Oct2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class T01DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();

        int[] males = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int male : males) {
            maleStack.push(male);
        }

        int[] females = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int female : females) {
            femaleQueue.offer(female);
        }

        int matches = 0;
        while (!femaleQueue.isEmpty() || !maleStack.isEmpty()) {
            if (maleStack.isEmpty() || femaleQueue.isEmpty()) {
                break;
            }
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

        if (!maleStack.isEmpty()) {
            System.out.print("Males left: ");
            System.out.println(String.join(", ", maleStack.toString())
                    .replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("Males left: none");
        }

        if (!femaleQueue.isEmpty()) {
            System.out.print("Females left: ");
            System.out.println(String.join(", ", femaleQueue.toString())
                    .replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("Females left: none");
        }
    }
}