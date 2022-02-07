package M03_JavaAdvanced.ExamPreparation.Exam15December2021.T03WaterAdventure;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.fishInPool = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        if (!this.fishInPool.contains(fish) && this.getFishInPool() < this.getCapacity()) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        return this.fishInPool
                .removeIf(fish -> fish.getName().equals(name));
    }

    public Fish findFish(String name) {
        return this.fishInPool
                .stream()
                .filter(fish -> fish.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public String report() {
        StringBuilder message = new StringBuilder();

        message.append(String.format("Aquarium: %s ^ Size: %s", this.name, this.size));
        message.append(System.lineSeparator());

        for (Fish fish : this.fishInPool) {
            message.append(fish)
                    .append(System.lineSeparator());
        }

        return message.toString().trim();
    }
}
