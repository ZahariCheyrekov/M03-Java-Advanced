package M03_JavaAdvanced.ExamPreparation.Exam17Dec2019;

import java.util.*;

public class T01SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] materials = readElements(scanner);

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        for (int material : materials) {
            materialsStack.push(material);
        }

        int[] magicLevel = readElements(scanner);

        ArrayDeque<Integer> magicLevelQueue = new ArrayDeque<>();
        for (int magic : magicLevel) {
            magicLevelQueue.offer(magic);
        }

        Map<String, Integer> presents = new TreeMap<>();

        int dolls = 0;
        int trains = 0;
        int bears = 0;
        int bicycles = 0;

        while (materialsStack.size() > 0 || magicLevelQueue.size() > 0) {
            if (magicLevelQueue.isEmpty() || materialsStack.isEmpty()) {
                break;
            }

            int values = magicLevelQueue.peek();
            int boxes = materialsStack.peek();
            int product = values * boxes;

            if (product < 0) {
                int result = values + boxes;
                magicLevelQueue.poll();
                materialsStack.pop();
                materialsStack.push(result);

            } else if (boxes == 0 || values == 0) {
                if (boxes == 0) {
                    materialsStack.pop();
                }
                if (values == 0) {
                    magicLevelQueue.poll();
                }

            } else if (product == 150 || product == 250 || product == 300 || product == 400) {
                String gift;
                if (product == 150) {
                    dolls++;
                    gift = "Doll";
                    magicLevelQueue.poll();
                    materialsStack.pop();

                    presents.putIfAbsent(gift, 0);
                    presents.put(gift, presents.get(gift) + 1);

                } else if (product == 250) {
                    trains++;
                    gift = "Wooden train";
                    magicLevelQueue.poll();
                    materialsStack.pop();

                    presents.putIfAbsent(gift, 0);
                    presents.put(gift, presents.get(gift) + 1);

                } else if (product == 300) {
                    bears++;
                    gift = "Teddy bear";
                    magicLevelQueue.poll();
                    materialsStack.pop();

                    presents.putIfAbsent(gift, 0);
                    presents.put(gift, presents.get(gift) + 1);

                } else {
                    bicycles++;
                    gift = "Bicycle";
                    magicLevelQueue.poll();
                    materialsStack.pop();

                    presents.putIfAbsent(gift, 0);
                    presents.put(gift, presents.get(gift) + 1);
                }
            } else if (product > 0) {
                magicLevelQueue.poll();
                boxes += 15;
                materialsStack.pop();
                materialsStack.push(boxes);
            }
        }

        boolean craftedPresents = (dolls >= 1 && trains >= 1) ||
                (bears >= 1 && bicycles >= 1);

        if (craftedPresents) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materialsStack.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.println(String.join(", ", materialsStack.toString()
                    .replaceAll("[\\[\\]]", "")));
        }

        if (!magicLevelQueue.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(String.join(", ", magicLevelQueue.toString()
                    .replaceAll("[\\[\\]]", "")));
        }

        presents.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));

    }

    private static int[] readElements(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}