package M03_JavaAdvanced.L08_IteratorsAndComparators.Exercises.T05ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();

        List<Person> people = new ArrayList<>();

        while (!input.equals("END")) {
            String[] lines = input.split("\\s+");
            people.add(new Person(lines[0], Integer.parseInt(lines[1]), lines[2]));
            input = bufferedReader.readLine();
        }
        int nthPerson = Integer.parseInt(bufferedReader.readLine());

        int equalPeople = 0;
        int totalPeople = people.size();
        int notEqualPeople = totalPeople;

        Person person = null;
        try {
            person = people.get(nthPerson);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No matches");
            return;
        }

        people.remove(person);


        for (Person otherPerson : people) {
            int result = person.compareTo(otherPerson);
            if (result == 0) {
                equalPeople++;
            }
        }

        if (equalPeople == 0) {
            System.out.println("No matches");
        } else {
            equalPeople++;
            notEqualPeople -= equalPeople;
            System.out.printf("%s %s %s%n", equalPeople, notEqualPeople, totalPeople);
        }
    }
}