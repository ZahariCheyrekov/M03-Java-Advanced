package M03_JavaAdvanced.ExamPreparation.Exam10June2018;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T03Genome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> organisms = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("(?<name>[!@#$?a-z]+)=(?<length>\\d+)--(?<genes>\\d+)<<(?<organism>[a-z]+)");
        String input = scanner.nextLine();
        while (!input.equals("Stop!")) {
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String name = matcher.group("name");
                int nameLength = Integer.parseInt(matcher.group("length"));
                int genesCount = Integer.parseInt(matcher.group("genes"));
                String organism = matcher.group("organism");

                name = name.replaceAll("[!@#$?]", "");

                if (name.length() == nameLength) {
                    organisms.putIfAbsent(organism, 0);
                    organisms.replace(organism, organisms.get(organism) + genesCount);
                }
            }

            input = scanner.nextLine();
        }

        organisms.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(o ->
                        System.out.printf("%s has genome size of %d%n", o.getKey(), o.getValue()));
    }
}