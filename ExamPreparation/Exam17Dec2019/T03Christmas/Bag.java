package M03_JavaAdvanced.ExamPreparation.Exam17Dec2019.T03Christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.capacity > this.data.size()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            Present present = this.data.get(i);
            if (present.getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent() {
        return this.data.stream()
                .max(Comparator.comparingDouble(Present::getWeight)).orElse(null);
    }

    public Present getPresent(String name) {
        return this.data.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        StringBuilder str = new StringBuilder(String.format("%s bag contains:%n", this.getColor()));
        for (Present present : this.data) {
            str.append(present.toString()).append(System.lineSeparator());
        }
        return str.toString().trim();
    }
}