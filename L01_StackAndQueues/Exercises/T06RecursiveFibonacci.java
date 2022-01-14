package M03_JavaAdvanced.L01_StackAndQueues.Exercises;

import java.util.Scanner;

public class T06RecursiveFibonacci {
    public static long[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        dp = new long[num + 1];

        long fibonacci = getFibonacci(num);

        System.out.println(fibonacci);
    }

    private static long getFibonacci(int num) {
        if (num < 2) {
            return 1;
        }

        if (dp[num] != 0) {
            return dp[num];
        }

        return dp[num] = getFibonacci(num - 1) + getFibonacci(num - 2);
    }
}