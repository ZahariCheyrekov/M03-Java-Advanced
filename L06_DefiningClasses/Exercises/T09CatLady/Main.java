package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T09CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Cat> cats = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String catType = data[0];
            String name = data[1];
            Cat cat = null;

            switch (catType) {
                case "Siamese":
                    double earSize = Double.parseDouble(data[2]);
                    cat = new Siamese(name, earSize);
                    break;

                case "Cymric":
                    double furLength = Double.parseDouble(data[2]);
                    cat = new Cymric(name, furLength);
                    break;

                case "StreetExtraordinaire":
                    double decibels = Double.parseDouble(data[2]);
                    cat = new StreetExtraordinaire(name, decibels);
                    break;
            }
            cats.put(name, cat);

            input = scanner.nextLine();
        }

        String catName = scanner.nextLine();
        System.out.println(cats.get(catName).toString());
    }
}