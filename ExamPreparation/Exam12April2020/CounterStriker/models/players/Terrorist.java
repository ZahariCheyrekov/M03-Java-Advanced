package M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.players;

import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.guns.Gun;

public class Terrorist extends PlayerImpl{
    public Terrorist(String username, int health, int armor, Gun gun) {
        super(username, health, armor, gun);
    }
}