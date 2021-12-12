package M03_JavaAdvanced.L03_SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class T09UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> users = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String ip = input.substring(input.indexOf("=") + 1, input.indexOf(" "));
            String user = input.substring(input.lastIndexOf("=") + 1);

            users.putIfAbsent(user, new LinkedHashMap<>());
            users.get(user).putIfAbsent(ip, 0);
            users.get(user).put(ip, users.get(user).get(ip) + 1);

            input = scanner.nextLine();
        }

        users.forEach((key, value) -> {
            System.out.println(key + ":");
            int count = 0;
            for (Map.Entry<String, Integer> secondMap : value.entrySet()) {
                String format =
                        (count++ == value.size() - 1)
                                ? "%s => %d.%n"
                                : "%s => %d, ";
                System.out.printf(format, secondMap.getKey(), secondMap.getValue());
            }
        });
    }
}