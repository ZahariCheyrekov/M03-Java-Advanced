package M03_JavaAdvanced.L01_StackAndQueues.Exercises;

import java.io.IOException;
import java.util.*;

public class T09PoisonousPlants {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Integer> plantsData = new ArrayList<>();

        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfPlants; i++) {
            int current = scanner.nextInt();
            plantsData.add(current);
        }

        ArrayDeque<Integer> removeElements = new ArrayDeque<>();

        int days = 0;
        boolean areRemoved = false;
        while (!areRemoved) {

            int removedElements = 0;
            for (int i = 0; i < plantsData.size() - 1; i++) {
                int currentElement = plantsData.get(i);
                int nextElement = plantsData.get(i + 1);

                if (currentElement < nextElement) {
                    removeElements.offer(nextElement);
                    removedElements++;
                }
            }
            if (removedElements == 0) {
                areRemoved = true;
            }
            while (!removeElements.isEmpty()) {
                plantsData.remove(removeElements.poll());
            }
            days++;
        }
        System.out.println(days - 1);
    }
}