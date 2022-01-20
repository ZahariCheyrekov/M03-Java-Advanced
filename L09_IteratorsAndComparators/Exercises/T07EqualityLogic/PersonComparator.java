package M03_JavaAdvanced.L09_IteratorsAndComparators.Exercises.T07EqualityLogic;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        PersonNameComparator nameComparator = new PersonNameComparator();
        PersonAgeComparator personAgeComparator = new PersonAgeComparator();

        int nameResult = nameComparator.compare(o1, o2);
        int ageResult = personAgeComparator.compare(o1, o2);

        if(nameResult != 0){
            return nameResult;
        }
        if(ageResult != 0){
            return ageResult;
        }

        return 0;
    }
}