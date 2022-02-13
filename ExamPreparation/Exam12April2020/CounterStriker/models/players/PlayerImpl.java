package M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.players;

import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.guns.Gun;

import static M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public void takeDamage(int points) {
        int damage = points;
        if (damage >= this.getArmor()) {
            damage -= this.getArmor();
            this.armor = 0;
            this.health -= damage;
        } else {
            this.armor -= damage;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %s", this.getClass().getSimpleName(), this.username)).append(System.lineSeparator());
        sb.append(String.format("--Health: %d", this.health)).append(System.lineSeparator());
        sb.append(String.format("--Armor: %d", this.armor)).append(System.lineSeparator());
        sb.append(String.format("--Gun: %s", this.gun.getName()));

        return sb.toString().trim();
    }
}