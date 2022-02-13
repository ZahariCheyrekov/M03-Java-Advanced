package M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.guns;

public class Rifle extends GunImpl {
    private static final int BULLETS_TO_SHOOT = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < BULLETS_TO_SHOOT) {
            return 0;
        }
        super.decreaseBullets(BULLETS_TO_SHOOT);
        return BULLETS_TO_SHOOT;
    }
}