package M03_JavaAdvanced.L03_SetsAndMaps.Lab;

import java.util.*;

public class T08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Double> studentsGrades = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();

            double sum = 0;
            for (Double grade : grades) {
                sum += grade;
            }
            double average = sum / grades.length;
            studentsGrades.putIfAbsent(name, average);
        }
        studentsGrades.forEach((key, value) ->
                System.out.printf("%s is graduated with " + value + "%n", key));
    }
}