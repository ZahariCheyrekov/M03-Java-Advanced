package M03_JavaAdvanced.L08_IteratorsAndComparators.Exercises.T07EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Person> personTreeSet = new TreeSet<>();
        HashSet<Person> personHashSet = new HashSet<>();

        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            String[] lines = bufferedReader.readLine().split("\\s+");
            people.add(new Person(lines[0], Integer.parseInt(lines[1])));
        }

        personTreeSet.addAll(people);
        personHashSet.addAll(people);

        System.out.println(personTreeSet.size());
        System.out.println(personHashSet.size());
    }
}