package M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.players;

import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.guns.Gun;

public class CounterTerrorist extends PlayerImpl{
    public CounterTerrorist(String username, int health, int armor, Gun gun) {
        super(username, health, armor, gun);
    }
}