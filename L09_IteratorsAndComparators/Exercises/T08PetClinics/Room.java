package M03_JavaAdvanced.L09_IteratorsAndComparators.Exercises.T08PetClinics;

public class Room {
    public Pet pet;

    public Room(){
        this.pet = null;
    }

    @Override
    public String toString() {
        if(pet == null){
            return "Room empty";
        }
        else{
            return pet.toString();
        }
    }
}