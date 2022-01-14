package M03_JavaAdvanced.L01_StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int num = Integer.parseInt(scanner.nextLine());

        if (num == 0) {
            System.out.println(0);
        } else {
            while (num != 0) {
                if (num % 2 == 0) {
                    stack.push(0);
                } else {
                    stack.push(1);
                }
                num /= 2;
            }
        }

        while (stack.size() > 0) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}