package M03_JavaAdvanced.L01_StackAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean areBalanced = true;

        ArrayDeque<Character> stack = new ArrayDeque<>();
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);

            if (currentBracket == '(' || currentBracket == '[' || currentBracket == '{') {
                stack.push(currentBracket);
            } else if (currentBracket == ')' || currentBracket == ']' || currentBracket == '}') {
                if (stack.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char lastBracket = stack.pop();
                if (lastBracket == '(' && currentBracket == ')') {
                    areBalanced = true;
                } else if (lastBracket == '[' && currentBracket == ']') {
                    areBalanced = true;
                } else if (lastBracket == '{' && currentBracket == '}') {
                    areBalanced = true;
                } else {
                    areBalanced = false;
                    break;
                }
            }
        }
        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}