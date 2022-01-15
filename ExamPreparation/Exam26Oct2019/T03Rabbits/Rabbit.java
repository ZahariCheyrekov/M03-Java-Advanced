package M03_JavaAdvanced.ExamPreparation.Exam26Oct2019.T03Rabbits;

public class Rabbit {
    private String name;
    private String species;
    private boolean available;

    public Rabbit(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable() {
        this.available = false;
    }

    public String toString() {
        return String.format("Rabbit (%s): %s%n",
                this.getSpecies(), this.getName());
    }
}
