package M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.field;

import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.players.CounterTerrorist;
import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.players.Player;
import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.models.players.Terrorist;

import java.util.*;
import java.util.stream.Collectors;

import static M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.common.OutputMessages.*;

public class FieldImpl implements Field {
    @Override
    public String start(Collection<Player> players) {
        List<Player> contraTerrorists = players
                .stream()
                .filter(p -> p instanceof CounterTerrorist)
                .collect(Collectors.toList());

        List<Player> terrorists = players
                .stream()
                .filter(p -> p instanceof Terrorist)
                .collect(Collectors.toList());

        while (contraTerrorists.stream().anyMatch(Player::isAlive) && terrorists.stream().anyMatch(Player::isAlive)) {
            for (Player terrorist : terrorists) {
                for (Player contraTerrorist : contraTerrorists) {
                    contraTerrorist.takeDamage(terrorist.getGun().fire());
                }
            }

            contraTerrorists = contraTerrorists.stream().filter(Player::isAlive).collect(Collectors.toList());

            for (Player contraTerrorist : contraTerrorists) {
                for (Player terrorist : terrorists) {
                    terrorist.takeDamage(contraTerrorist.getGun().fire());
                }
            }

            terrorists = terrorists.stream().filter(Player::isAlive).collect(Collectors.toList());
        }
        return terrorists.stream().anyMatch(Player::isAlive) ? TERRORIST_WINS : COUNTER_TERRORIST_WINS;
    }
}