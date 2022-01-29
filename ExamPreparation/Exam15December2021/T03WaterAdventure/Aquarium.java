package M03_JavaAdvanced.ExamPreparation.Exam15December2021.T03WaterAdventure;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSize() {
        return this.size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        if (this.getFishInPool() < this.getCapacity()) {
            if (!this.fishInPool.contains(fish)) {
                this.fishInPool.add(fish);
            }
        }
    }

    public boolean remove(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                this.fishInPool.remove(fish);
                return true;
            }
        }

        return false;
    }

    public Fish findFish(String name) {
        return this.fishInPool.stream().filter(fish -> fish.getName()
                .equals(name)).findFirst()
                .orElse(null);
    }

    public String report() {
        StringBuilder report = new StringBuilder();

        report.append(String.format("Aquarium: %s ^ Size: %d", this.getName(), this.getSize()))
                .append(System.lineSeparator());

        for (Fish fish : this.fishInPool) {
            report.append(fish.toString())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
