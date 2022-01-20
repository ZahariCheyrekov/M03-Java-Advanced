package M03_JavaAdvanced.L10_BasicAlgorithms;

import java.util.Scanner;

public class T02RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        long factorial = findFactorial(n);
        System.out.println(factorial);
    }

    private static long findFactorial(int number) {
        if (number == 0) {
            return 1;
        }

        return number * findFactorial(number - 1);
    }
}