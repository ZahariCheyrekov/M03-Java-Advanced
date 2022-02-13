package M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.core;

import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.field.Field;
import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.field.FieldImpl;
import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.guns.Gun;
import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.guns.Pistol;
import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.guns.Rifle;
import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.players.CounterTerrorist;
import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.players.Player;
import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.players.Terrorist;
import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.repositories.GunRepository;
import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.repositories.PlayerRepository;
import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.repositories.Repository;

import java.util.Collection;
import java.util.stream.Collectors;

import static M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.common.ExceptionMessages.*;
import static M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Gun> guns;
    private Repository<Player> players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository<>();
        this.players = new PlayerRepository<>();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun;
        if ("Pistol".equals(type)) {
            gun = new Pistol(name, bulletsCount);
        } else if ("Rifle".equals(type)) {
            gun = new Rifle(name, bulletsCount);
        } else {
            throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        this.guns.add(gun);
        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gun = this.guns.findByName(gunName);
        if (gun == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }
        Player player;
        if ("CounterTerrorist".equals(type)) {
            player = new CounterTerrorist(username, health, armor, gun);
        } else if ("Terrorist".equals(type)) {
            player = new Terrorist(username, health, armor, gun);
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        this.players.add(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        Collection<Player> players = this
                .players
                .getModels()
                .stream()
                .filter(Player::isAlive)
                .collect(Collectors.toList());
        return this.field.start(players);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        this
                .players
                .getModels()
                .stream()
                .sorted((p1, p2) -> {
                    int result = p1.getClass().getSimpleName().compareTo(p2.getClass().getSimpleName());
                    if (result == 0) {
                        result = Integer.compare(p2.getHealth(), p1.getHealth());
                    }
                    if (result == 0) {
                        result = p1.getUsername().compareTo(p2.getUsername());
                    }
                    return result;
                })
                .forEach(p -> sb
                        .append(p)
                        .append(System.lineSeparator()));
        return sb.toString().trim();
    }
}