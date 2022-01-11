package M03_JavaAdvanced.L08_IteratorsAndComparators.Exercises.T05ComparingObjects;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person o) {
        int nameResult = this.name.compareTo(o.name);

        if (nameResult != 0) {
            return nameResult;
        }

        int ageResult = Integer.compare(this.age, o.age);

        if (ageResult != 0) {
            return ageResult;
        }

        return this.town.compareTo(o.town);
    }
}