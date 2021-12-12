package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T09CatLady;

public class Cymric extends Cat {
    private double lengthFur;

    public Cymric(String name, double lengthFur) {
        super(name);
        this.lengthFur = lengthFur;
    }

    public String toString() {
        return String.format("Cymric %s %.2f", super.getName(), this.lengthFur);
    }
}