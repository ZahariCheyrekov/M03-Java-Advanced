package M03_JavaAdvanced.L03_SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T13SerbianMusicUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?<singer>\\w+(?: \\w+)*) @(?<venue>[\\w]+(?: \\w+)*) (?<ticketsPrice>[\\d]+) (?<ticketsCount>[\\d]+)");

        Map<String, Map<String, Integer>> venues = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {

            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int ticketPrice = Integer.parseInt(matcher.group("ticketsPrice"));
                int ticketsCount = Integer.parseInt(matcher.group("ticketsCount"));

                int price = ticketPrice * ticketsCount;

                venues.putIfAbsent(venue, new LinkedHashMap<>());
                venues.get(venue).putIfAbsent(singer, 0);
                venues.get(venue).put(singer, venues.get(venue).get(singer) + price);
            }
            input = scanner.nextLine();
        }
        venues.entrySet()
                .forEach(key -> {
                    System.out.println(key.getKey());
                    key.getValue()
                            .entrySet()
                            .stream()
                            .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                            .forEach(entry -> System.out.printf("#  %s -> %d%n", entry.getKey(), entry.getValue()));
                });
    }
}