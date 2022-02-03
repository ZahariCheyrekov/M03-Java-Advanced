package M03_JavaAdvanced.ExamPreparation.Exam27August2018;

import java.util.*;
import java.util.stream.Collectors;

public class T01Agency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = fillStack(scanner);
        ArrayDeque<String> queue = fillQueue(scanner);

        String input = scanner.nextLine();
        while (!input.equals("stop")) {

            String[] data = input.split("[\\s]+");
            String command = data[0];

            switch (command) {
                case "add-ID":
                    String number = data[1];
                    stack.push(number);
                    break;

                case "add-agent":
                    String agent = data[1];
                    queue.offer(agent);
                    break;

                case "remove-ID":
                    String ID = stack.pop();
                    System.out.printf("%s has been removed.%n", ID);
                    break;

                case "remove-agent":
                    String agentRemove = queue.removeLast();
                    System.out.printf("%s has left the queue.%n", agentRemove);
                    break;

                case "sort-ID":
                    List<String> numbers = new ArrayList<>(stack);

                    Collections.sort(numbers);
                    Collections.reverse(numbers);

                    stack = new ArrayDeque<>(numbers);
            }
            input = scanner.nextLine();
        }

        boolean bothAreEmpty = false;
        while (!bothAreEmpty) {
            if (!stack.isEmpty() && !queue.isEmpty()) {
                String number = stack.pop();
                String agent = queue.poll();

                System.out.printf("%s takes ID number: %s%n", agent, number);

            } else if (!stack.isEmpty() && queue.isEmpty()) {
                System.out.println("No more agents left.");

                while (!stack.isEmpty()) {
                    String number = stack.pop();
                    System.out.printf("ID number: %s%n", number);
                }
                bothAreEmpty = true;

            } else if (stack.isEmpty() && !queue.isEmpty()) {

                while (!queue.isEmpty()) {
                    String agent = queue.poll();
                    System.out.printf("%s does not have an ID.%n", agent);
                }
                bothAreEmpty = true;
            }

            if (stack.isEmpty() && queue.isEmpty()) {
                bothAreEmpty = true;
            }
        }
    }

    private static ArrayDeque<String> fillStack(Scanner scanner) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] numbers = scanner.nextLine().split("[\\s]+");

        for (String number : numbers) {
            stack.push(number);
        }

        return stack;
    }

    private static ArrayDeque<String> fillQueue(Scanner scanner) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] agents = scanner.nextLine().split("[\\s]+");

        for (String agent : agents) {
            queue.offer(agent);
        }

        return queue;
    }
}