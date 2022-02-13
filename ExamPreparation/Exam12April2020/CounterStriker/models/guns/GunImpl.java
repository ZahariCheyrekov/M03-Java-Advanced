package M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.guns;

import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.common.ExceptionMessages;

public abstract class GunImpl implements Gun {
    private String name;
    private int bulletsCount;

    protected GunImpl(String name, int bulletsCount) {
        this.setName(name);
        this.setBulletsCount(bulletsCount);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.INVALID_GUN_NAME);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setBulletsCount(int bulletsCount) {
        if (bulletsCount < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }

    protected void decreaseBullets(int amount) {
        this.bulletsCount -= amount;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }
}