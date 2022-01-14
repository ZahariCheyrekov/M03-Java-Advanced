package M03_JavaAdvanced.L01_StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (stack.size() < 2) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    stack.pop();
                    String prevURL = stack.peek();
                    System.out.println(prevURL);
                }
            } else {
                stack.push(input);
                System.out.println(input);
            }
            input = scanner.nextLine();
        }
    }
}