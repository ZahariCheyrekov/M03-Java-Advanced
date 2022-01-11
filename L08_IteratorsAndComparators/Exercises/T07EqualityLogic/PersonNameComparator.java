package M03_JavaAdvanced.L08_IteratorsAndComparators.Exercises.T07EqualityLogic;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int nameLengthResult = Integer.compare(o1.getName().length(), o2.getName().length());
        if (nameLengthResult == 0) {
            return o1.getName().compareTo(o2.getName());
        }

        return nameLengthResult;
    }
}