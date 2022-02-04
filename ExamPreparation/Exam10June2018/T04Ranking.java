package M03_JavaAdvanced.ExamPreparation.Exam10June2018;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class T04Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contests = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end of contests")) {
            String[] data = input.split(":");
            contests.putIfAbsent(data[0], data[1]);

            input = scanner.nextLine();
        }

        Map<String, Map<String, Integer>> usersData = new TreeMap<>();

        input = scanner.nextLine();
        while (!input.equals("end of submissions")) {
            String[] data = input.split("=>");
            String contest = data[0];
            String password = data[1];
            String username = data[2];
            Integer points = Integer.parseInt(data[3]);

            if (contests.containsKey(contest)) {

                if (contests.get(contest).equals(password)) {
                    usersData.putIfAbsent(username, new HashMap<>());
                    usersData.get(username).putIfAbsent(contest, 0);

                    if (usersData.get(username).get(contest) < points) {
                        usersData.get(username).replace(contest, points);
                    }
                }
            }
            input = scanner.nextLine();
        }

        usersData.entrySet()
                .stream()
                .sorted((x, y) -> Integer.compare(y.getValue().values().stream().mapToInt(Integer::valueOf).sum(),
                        x.getValue().values().stream().mapToInt(Integer::valueOf).sum()))
                .limit(1)
                .forEach(z -> System.out.printf("Best candidate is %s with total %d points.%n",
                        z.getKey(),
                        z.getValue().values().stream().mapToInt(Integer::valueOf).sum()));

        System.out.println("Ranking: ");

        usersData.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(w -> System.out.printf("#  %s -> %d%n",
                            w.getKey(),
                            w.getValue()));
        });
    }
}