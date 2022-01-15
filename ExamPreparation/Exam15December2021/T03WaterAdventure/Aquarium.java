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
        return fishInPool.size();
    }

    public void add(Fish fish) {
        if (!fishInPool.contains(fish)) {
            if (fishInPool.size() < size) {
                fishInPool.add(fish);
            }
        }
    }

    public Fish findFish(String name) {
        Fish fishName = null;

        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                fishName = fish;
            }
        }

        return fishName;
    }

    public boolean remove(String name) {
        boolean isSuccessful = false;

        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                fishInPool.remove(fish);
                isSuccessful = true;
                break;
            }
        }

        return isSuccessful;
    }

    public StringBuilder report() {
        StringBuilder fishInfo = new StringBuilder();

        fishInfo.append(String.format("Aquarium: %s ^ Size: %d%n", this.name, this.size));

        for (Fish fish : fishInPool) {
            fishInfo.append(fish);
        }

        return fishInfo;
    }
}