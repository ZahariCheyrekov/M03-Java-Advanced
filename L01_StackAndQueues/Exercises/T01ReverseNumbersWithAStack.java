package M03_JavaAdvanced.L01_StackAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split("\\s+");

        if (numbers.length == 1) {
            System.out.println(numbers[0]);
        } else {
            ArrayDeque<String> stack = new ArrayDeque<>();
            for (String num : numbers) {
                stack.push(num);
            }
            System.out.println(String.join(" ", stack));
        }
    }
}