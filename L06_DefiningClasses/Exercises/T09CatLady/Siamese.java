package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T09CatLady;

public class Siamese extends Cat {
    private double earsSize;

    public Siamese(String name, double earsSize) {
        super(name);
        this.earsSize = earsSize;
    }

    public String toString() {
        return String.format("Siamese %s %.2f", super.getName(), this.earsSize);
    }
}