package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T07Google;

public class Child {
    private String childName;
    private String childBirthday;

    public Child(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    public String toString() {
        return childName + " " + childBirthday;
    }
}