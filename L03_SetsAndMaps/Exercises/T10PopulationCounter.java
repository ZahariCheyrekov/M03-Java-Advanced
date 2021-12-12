package M03_JavaAdvanced.L03_SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class T10PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Long>> countriesAndCities = new LinkedHashMap<>();
        Map<String, Long> countriesOnly = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("report")) {
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            Long population = Long.parseLong(data[2]);

            if (!countriesAndCities.containsKey(country)) {
                countriesAndCities.put(country, new LinkedHashMap<>());
                countriesOnly.put(country, 0L);
            }
            countriesOnly.put(country, countriesOnly.get(country) + population);
            if (!countriesAndCities.get(country).containsKey(city)) {
                countriesAndCities.get(country).put(city, population);
            }
            input = scanner.nextLine();
        }
        countriesAndCities.entrySet().stream()
                .sorted((c1, c2) -> countriesOnly.get(c2.getKey()).compareTo(countriesOnly.get(c1.getKey())))
                .forEach(country -> {
                    System.out.format("%s (total population: %d)\n", country.getKey(), countriesOnly.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream().sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                            .forEach(city -> System.out.format("=>%s: %d\n", city.getKey(), city.getValue()));
                });
    }
}