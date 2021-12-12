package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T01OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            if (age > 30) {
                Person person = new Person(name, age);
                people.add(person);
            }
        }

        people.sort(Comparator.comparing(Person::getName));
        people.forEach(person -> System.out.println(person.getInfo()));
    }
}