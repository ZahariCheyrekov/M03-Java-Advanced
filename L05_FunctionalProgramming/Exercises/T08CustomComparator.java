package M03_JavaAdvanced.L05_FunctionalProgramming.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class T08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (Integer num : numbers) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }

        Collections.sort(even);
        Collections.sort(odd);

        List<Integer> result = new ArrayList<>();
        result.addAll(even);
        result.addAll(odd);


        result.forEach(num -> System.out.print(num + " "));
    }
}