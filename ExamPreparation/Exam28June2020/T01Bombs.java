package M03_JavaAdvanced.ExamPreparation.Exam28June2020;

import java.util.*;

public class T01Bombs {
    public static Map<String, Integer> createdBombs = new TreeMap<>();
    public static int DaturaBombs = 0;
    public static int CherryBombs = 0;
    public static int SmokeDecoyBombs = 0;

    public static boolean hasFilledCouch = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        createdBombs.put("Cherry Bombs", 0);
        createdBombs.put("Datura Bombs", 0);
        createdBombs.put("Smoke Decoy Bombs", 0);

        int[] effects = readData(scanner);
        ArrayDeque<Integer> bombsQueue = new ArrayDeque<>();
        fillQueue(bombsQueue, effects);

        int[] casings = readData(scanner);
        ArrayDeque<Integer> bombsStack = new ArrayDeque<>();
        fillStack(bombsStack, casings);


        while (!bombsStack.isEmpty() && !bombsQueue.isEmpty()) {

            int effect = bombsStack.peek();
            int casing = bombsQueue.peek();

            int sum = effect + casing;

            String bomb = null;
            switch (sum) {
                case 40:
                    bombsQueue.poll();
                    bombsStack.pop();
                    bomb = "Datura Bombs";
                    DaturaBombs++;
                    break;

                case 60:
                    bombsQueue.poll();
                    bombsStack.pop();
                    bomb = "Cherry Bombs";
                    CherryBombs++;
                    break;

                case 120:
                    bombsQueue.poll();
                    bombsStack.pop();
                    bomb = "Smoke Decoy Bombs";
                    SmokeDecoyBombs++;
                    break;

                default:
                    int bombCasing = bombsStack.pop() - 5;
                    bombsStack.push(bombCasing);
                    break;
            }

            if (bomb != null) {
                createdBombs.put(bomb, createdBombs.get(bomb) + 1);
            }

            if (DaturaBombs >= 3 && CherryBombs >= 3 && SmokeDecoyBombs >= 3) {
                hasFilledCouch = true;
                break;
            }
        }

        if (hasFilledCouch) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            System.out.println(bombsQueue.toString()
                    .replaceAll("[\\[\\]]", ""));
        }

        if (bombsStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            System.out.println(bombsStack.toString()
                    .replaceAll("[\\[\\]]", ""));
        }

        createdBombs.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }

    private static void fillQueue(ArrayDeque<Integer> bombsQueue, int[] casings) {
        for (int num : casings) {
            bombsQueue.offer(num);
        }
    }

    private static void fillStack(ArrayDeque<Integer> bombsStack, int[] effects) {
        for (int num : effects) {
            bombsStack.push(num);
        }
    }

    private static int[] readData(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("[,\\s]+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
