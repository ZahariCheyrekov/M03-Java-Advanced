package M03_JavaAdvanced.L01_StackAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T08InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<String> numbersQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();

        for (String current : tokens) {
            if (Character.isDigit(current.charAt(0)) || Character.isLetter(current.charAt(0))) {
                numbersQueue.offer(current);
            } else {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(current);
                } else {
                    String lastOperator = operatorStack.peek();
                    switch (current) {
                        case "+":
                        case "-":
                            if (lastOperator.equals("(")) {
                                operatorStack.push(current);
                            } else {
                                numbersQueue.offer(operatorStack.pop());
                                operatorStack.push(current);
                            }
                            break;
                        case "*":
                        case "/":
                            if (lastOperator.equals("*") || lastOperator.equals("/")) {
                                numbersQueue.offer(operatorStack.pop());
                                operatorStack.push(current);
                            } else {
                                operatorStack.push(current);
                            }
                            break;
                        case "(":
                            operatorStack.push(current);
                            break;
                        case ")":
                            while (!operatorStack.peek().equals("(")) {
                                numbersQueue.offer(operatorStack.pop());
                            }
                            operatorStack.pop();
                            break;
                    }
                }
            }
        }

        while (!numbersQueue.isEmpty()) {
            System.out.print(numbersQueue.poll() + " ");
        }

        while (!operatorStack.isEmpty()) {
            System.out.print(operatorStack.pop() + " ");
        }
        System.out.println();
    }
}