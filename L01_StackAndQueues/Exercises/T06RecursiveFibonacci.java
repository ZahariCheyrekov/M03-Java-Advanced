package M03_JavaAdvanced.L01_StackAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T06RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Long> Fibonacci = new ArrayDeque<>();
        long N = Integer.parseInt(scanner.nextLine());
        System.out.println(getFibonacci(Fibonacci, N));
    }

    private static Long getFibonacci(ArrayDeque<Long> Fibonacci, Long N) {
        if (N < 2) {
            return 1L;
        } else {
            Fibonacci.offer(0L);
            Fibonacci.offer(1L);
            for (int i = 0; i < N; i++) {
                long Sum = Fibonacci.poll() + Fibonacci.peek();
                Fibonacci.offer(Sum);
            }
        }
        Fibonacci.poll();
        return Fibonacci.peek();
    }
}