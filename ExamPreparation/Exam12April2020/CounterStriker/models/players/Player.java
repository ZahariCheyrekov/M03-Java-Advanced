package M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.players;

import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.guns.Gun;

public interface Player {
    String getUsername();

    int getHealth();

    int getArmor();

    Gun getGun();

    boolean isAlive();

    void takeDamage(int points);
}
