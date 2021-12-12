package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T01OpinionPoll;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getInfo() {
        return String.format("%s - %d",getName(),getAge());
    }
}