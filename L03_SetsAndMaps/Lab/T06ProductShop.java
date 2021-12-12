package M03_JavaAdvanced.L03_SetsAndMaps.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class T06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> productsMap = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String[] data = input.split(", ");
            String shop = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);

            productsMap.putIfAbsent(shop, new LinkedHashMap<>());
            productsMap.get(shop).put(product, price);
            input = scanner.nextLine();
        }

        productsMap.forEach((key1, value1) -> {
            System.out.println(key1 + "->");
            value1
                    .forEach((key, value) ->
                            System.out.printf("Product: %s, Price: %.1f %n", key, value));
        });
    }
}