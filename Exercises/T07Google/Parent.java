package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T07Google;

public class Parent {
    private String name;
    private String birthday;

    public Parent(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String toString() {
        return name + " " + birthday;
    }
}