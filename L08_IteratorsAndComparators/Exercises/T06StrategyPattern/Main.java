package M03_JavaAdvanced.L08_IteratorsAndComparators.Exercises.T06StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Person> peopleSortedByName = new TreeSet<>(new PersonNameComparator());
        TreeSet<Person> peopleSortedByAge = new TreeSet<>(new PersonAgeComparator());

        int n = Integer.parseInt(bufferedReader.readLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] lines = bufferedReader.readLine().split("\\s+");
            people.add(new Person(lines[0], Integer.parseInt(lines[1])));
        }

        peopleSortedByName.addAll(people);
        peopleSortedByAge.addAll(people);

        for (Person person : peopleSortedByName) {
            System.out.println(person);
        }

        for (Person person : peopleSortedByAge) {
            System.out.println(person);
        }
    }
}