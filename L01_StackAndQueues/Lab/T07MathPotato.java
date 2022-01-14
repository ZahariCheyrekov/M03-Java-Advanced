package M03_JavaAdvanced.L01_StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class T07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] data = scanner.nextLine().split("\\s+");
        Collections.addAll(queue, data);

        int kids = Integer.parseInt(scanner.nextLine());
        int num = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < kids; i++) {
                queue.offer(Objects.requireNonNull(queue.poll()));
            }
            boolean isPrime = num != 1;

            for (int i = 2; i <= num / 2; ++i) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            num++;
        }
        System.out.println("Last is " + queue.poll());
    }
}