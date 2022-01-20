package M03_JavaAdvanced.L09_IteratorsAndComparators.Exercises.T06StrategyPattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int nameLengthResult = Integer.compare(o1.getName().length(), o2.getName().length());
        if (nameLengthResult == 0) {
            return Character.compare(o1.getName().toUpperCase().charAt(0), o2.getName().toUpperCase().charAt(0));
        }

        return nameLengthResult;
    }
}