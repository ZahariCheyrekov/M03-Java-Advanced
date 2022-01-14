package M03_JavaAdvanced.L01_StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class T06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");
        Collections.addAll(queue, input);

        int kids = Integer.parseInt(scanner.nextLine());
        while (queue.size() > 1) {
            for (int i = 1; i < kids; i++) {
                queue.offer(Objects.requireNonNull(queue.poll()));
            }
            System.out.println("Removed " + queue.poll());
        }

        System.out.println("Last is " + queue.poll());
    }
}