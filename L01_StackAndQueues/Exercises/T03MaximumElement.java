package M03_JavaAdvanced.L01_StackAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class T03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberOfCommands; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            int numCommand = Integer.parseInt(tokens[0]);

            switch (numCommand) {
                case 1:
                    int element = Integer.parseInt(tokens[1]);
                    stack.push(element);
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case 3:
                    System.out.println(Collections.max(stack));
                    break;
                default:
                    break;
            }
        }
    }
}