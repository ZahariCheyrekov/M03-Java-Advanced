package M03_JavaAdvanced.L08_IteratorsAndComparators.Exercises.T07EqualityLogic;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}