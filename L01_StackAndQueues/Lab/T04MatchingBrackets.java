package M03_JavaAdvanced.L01_StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String input = scanner.nextLine();
        for (int index = 0; index < input.length(); index++) {
            char current = input.charAt(index);
            if (current == '(') {
                stack.push(index);
            } else if (current == ')') {
                int startIndex = stack.pop();
                String contest = input.substring(startIndex, index + 1);
                System.out.println(contest);
            }
        }
    }
}