package M03_JavaAdvanced.L01_StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");
        for (int i = input.length - 1; i >= 0; i--) {
            stack.push(input[i]);
        }

        int result = 0;
        while (stack.size() > 1) {
            int currentResult;
            int first = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int second = Integer.parseInt(stack.pop());

            currentResult = (operator.equals("+"))
                    ? first + second
                    : first - second;

            stack.push(String.valueOf(currentResult));
            result = currentResult;
        }
        System.out.println(result);
    }
}