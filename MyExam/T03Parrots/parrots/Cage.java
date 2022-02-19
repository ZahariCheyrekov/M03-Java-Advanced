package M03_JavaAdvanced.ExamPreparation.MyExam.T03Parrots.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.capacity > this.data.size()) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return this.data
                .removeIf(parrot -> parrot.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                break;
            }
        }

        return this.data
                .stream().filter(parrot -> parrot.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> forSelling = new ArrayList<>();

        for (Parrot parrot : this.data) {
            if (parrot.getSpecies().equals(species)) {
                forSelling.add(parrot);
                parrot.setAvailable(false);
            }
        }

        return forSelling;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder message = new StringBuilder();

        message.append(String.format("Parrots available at %s:", this.name))
                .append(System.lineSeparator());

        for (Parrot parrot : this.data) {
            if (parrot.isAvailable()) {
                message.append(parrot)
                        .append(System.lineSeparator());
            }
        }

        return message.toString().trim();
    }
}