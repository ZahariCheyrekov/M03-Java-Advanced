package M03_JavaAdvanced.ExamPreparation.Exam19August2020.T03VetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if(this.data.size() < this.capacity){
            this.data.add(pet);
        }
    }

    public boolean remove(String name){
        return data.removeIf(e -> e.getName().equals(name));
    }

    public Pet getPet(String name, String owner){
        return data.stream().filter(e ->
                e.getName().equals(name) && e.getOwner().equals(owner)).findFirst().orElseThrow();
    }

    public Pet getOldestPet(){
        return data.stream().max(Comparator.comparingInt(Pet::getAge)).get();
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        builder.append("The clinic has the following patients:").append(System.lineSeparator());

        data.forEach(pet ->
                builder.append(String.format("%s %s", pet.getName(), pet.getOwner())
                ).append(System.lineSeparator()));

        return builder.toString().trim();
    }
}