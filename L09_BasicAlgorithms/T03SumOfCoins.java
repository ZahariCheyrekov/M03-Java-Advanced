package M03_JavaAdvanced.L09_BasicAlgorithms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class T03SumOfCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().substring(7).split(", ");

        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(scanner.nextLine().substring(5));

        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Map<Integer, Integer> usedCoins = new LinkedHashMap<>();

        int index = coins.length - 1;

        while (targetSum != 0) {
            int coinsToTake = targetSum / coins[index];

            if (coinsToTake != 0) {
                usedCoins.put(coins[index], coinsToTake);
            }

            targetSum %= coins[index];
            index--;
        }

        return usedCoins;
    }
}