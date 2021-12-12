package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T07Google;

public class Pokemon {
    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String toString() {
        return name + " " + type;
    }
}