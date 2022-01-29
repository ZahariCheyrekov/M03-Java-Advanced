package M03_JavaAdvanced.ExamPreparation.Exam15December2021.T03WaterAdventure;

public class Fish {
    private String name;
    private String color;
    private int fins;

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getFins() {
        return fins;
    }

    @Override
    public String toString() {
        return String.format("Fish: %s%nColor: %s%nNumber of fins: %s",
                this.getName(), this.getColor(), this.getFins());
    }
}
