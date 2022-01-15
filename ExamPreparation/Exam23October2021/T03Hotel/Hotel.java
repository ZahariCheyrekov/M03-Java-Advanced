package M03_JavaAdvanced.ExamPreparation.Exam23October2021.T03Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.roster.size();
    }

    public void add(Person person) {
        if (this.getCount() < this.getCapacity()) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        return this.roster.removeIf(person -> person.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        return this.roster
                .stream()
                .filter(person -> person.getName().equals(name) && person.getHometown().equals(hometown))
                .findFirst()
                .orElse(null);
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();

        statistics.append(String.format("The people in the %s are:", this.getName()))
                .append(System.lineSeparator());

        for (Person person : this.roster) {
            statistics.append(person.toString())
                    .append(System.lineSeparator());
        }

        return statistics.toString();
    }
}
