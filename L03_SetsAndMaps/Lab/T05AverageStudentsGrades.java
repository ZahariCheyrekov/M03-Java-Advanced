package M03_JavaAdvanced.L03_SetsAndMaps.Lab;

import java.util.*;

public class T05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentsMap = new TreeMap<>();

        int students = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < students; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            double grade = Double.parseDouble(data[1]);

            studentsMap.putIfAbsent(name, new ArrayList<>());
            studentsMap.get(name).add(grade);
        }

        studentsMap.forEach((key, value) -> {
            double sum = 0;
            for (Double current : value) {
                sum += current;
            }
            double avgSum = sum / value.size();

            System.out.print(key + " -> ");
            value.forEach(e -> System.out.printf("%.2f ", e));
            System.out.printf("(avg: %.2f)%n", avgSum);
        });
    }
}