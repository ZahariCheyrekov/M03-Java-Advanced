package M03_JavaAdvanced.L01_StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.printf("Canceled %s%n", queue.poll());
                }
            } else {
                queue.offer(input);
            }
            input = scanner.nextLine();
        }

        System.out.println(String.join(System.lineSeparator(), queue));
    }
}