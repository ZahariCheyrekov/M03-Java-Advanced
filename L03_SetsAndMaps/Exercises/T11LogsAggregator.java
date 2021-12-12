package M03_JavaAdvanced.L03_SetsAndMaps.Exercises;

import java.util.*;

public class T11LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> users = new TreeMap<>();
        Map<String, TreeSet<String>> ips = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String ip = data[0];
            String user = data[1];
            int duration = Integer.parseInt(data[2]);

            if (!users.containsKey(user)) {
                users.put(user, duration);
                ips.put(user, new TreeSet<>());
            } else {
                users.put(user, users.get(user) + duration);
            }

            ips.get(user).add(ip);

        }
        Map<String, String> finalIPS = new LinkedHashMap<>();

        for (Map.Entry<String, TreeSet<String>> entry : ips.entrySet()) {
            String result = String.join(", ", entry.getValue());
            finalIPS.put(entry.getKey(), result);
        }

        users.entrySet()
                .stream().
                forEach(entry -> {
                    System.out.printf("%s: %d ", entry.getKey(), entry.getValue());
                    String ipsCurrent = entry.getKey();
                    System.out.printf("[%s]%n", finalIPS.get(ipsCurrent));
                });
    }
}