package M03_JavaAdvanced.L01_StackAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();

        ArrayDeque<String> stack = new ArrayDeque<>();
        int operations = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < operations; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(tokens[0]);

            switch (command) {
                case 1:
                    String string = tokens[1];
                    stack.push(stringBuilder.toString());
                    stringBuilder.append(string);
                    break;
                case 2:
                    stack.push(stringBuilder.toString());
                    int count = Integer.parseInt(tokens[1]);
                    stringBuilder.delete(stringBuilder.length() - count, stringBuilder.length());
                    break;
                case 3:
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(stringBuilder.charAt(index - 1));
                    break;
                case 4:
                    stringBuilder = new StringBuilder(stack.pop());
                    break;
            }
        }
    }
}