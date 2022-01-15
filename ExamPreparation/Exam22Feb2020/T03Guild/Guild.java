package M03_JavaAdvanced.ExamPreparation.Exam22Feb2020.T03Guild;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private Map<String, Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new LinkedHashMap<>();
    }

    public void addPlayer(Player player) {
        if (count() < capacity) {
            roster.putIfAbsent(player.getName(), player);
        }
    }

    public int count() {
        return roster.size();
    }

    public boolean removePlayer(String name) {
        return roster.remove(name) != null;
    }

    public void promotePlayer(String name) {
        roster.computeIfPresent(name, Guild::promotePlayer);
    }

    private static Player promotePlayer(String name, Player player) {
        player.setRank(Rank.MEMBER);
        return player;
    }

    public void demotePlayer(String name) {
        roster.computeIfPresent(name, Guild::demotePlayer);
    }

    private static Player demotePlayer(String name, Player player) {
        player.setRank(Rank.TRIAL);
        return player;
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] removed = roster.values().stream()
                .filter(player -> clazz.equals(player.getClazz()))
                .toArray(Player[]::new);

        for (Player player : removed) {
            roster.remove(player.getName());
        }

        return removed;
    }

    public String report() {
        return String.format(
                "Players in the guild: %s:%n%s", name,
                roster.values().stream()
                        .map(Player::toString)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}