package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T04RawData;

import java.util.ArrayList;

public class Car {
    private String model;
    private int engineSpeed;
    private int hp;
    private int cargoW;
    private String cargoType;
    private ArrayList<Tyre> tyres;

    public Car(String model, int engineSpeed, int hp, int cargoW, String cargoType, ArrayList<Tyre> tyres) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.hp = hp;
        this.cargoW = cargoW;
        this.cargoType = cargoType;
        this.tyres = tyres;
    }

    public ArrayList<Tyre> getTyres() {
        return tyres;
    }

    public String getModel() {
        return model;
    }

    public int getHp() {
        return hp;
    }
}