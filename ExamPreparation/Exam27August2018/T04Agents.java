package M03_JavaAdvanced.ExamPreparation.Exam27August2018;

import java.util.*;

public class T04Agents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> missions = new LinkedHashMap<>();
        List<String> agents = new LinkedList<>();
        Map<String, Map<String, Double>> agentMissions = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("registration")) {

            if (input.charAt(0) == '#') {
                String[] missionInfo = input.split(":");
                String name = missionInfo[0];
                Double rating = Double.parseDouble(missionInfo[1]);

                missions.put(name, rating);

            } else {
                agents.add(input);
            }
            input = scanner.nextLine();
        }
        
        input = scanner.nextLine();
        while (!input.equals("operate")) {

            String[] data = input.split("->+");
            String command = data[0];

            switch (command) {
                case "assign":
                    String agentName = data[1];
                    String missionName = data[2];

                    assignAgent(agentName, missionName, agents, agentMissions, missions);

                    break;

                case "abort":
                    String missionAbort = data[1];

                    abortMission(missionAbort, agentMissions);
                    break;

                case "change":
                    String agentNameOne = data[1];
                    String agentNameTwo = data[2];

                    changeMissions(agentNameOne, agentNameTwo, agentMissions);
                    break;
            }

            input = scanner.nextLine();
        }

        printMissions(agentMissions);
    }

    private static void assignAgent(String agent, String name, List<String> agents, Map<String,
            Map<String, Double>> agentMissions, Map<String, Double> missions) {

        if (missions.containsKey(name) && agents.contains(agent)) {
            agentMissions.putIfAbsent(agent, new LinkedHashMap<>());

            if (!agentMissions.get(agent).containsKey(name)) {
                agentMissions.get(agent).put(name, missions.get(name));
            }
        }
    }


    private static void abortMission(String abort, Map<String, Map<String, Double>> mission) {
        for (var entry : mission.entrySet()) {
            entry.getValue().remove(abort);
        }
    }

    private static void changeMissions(String one, String two, Map<String, Map<String, Double>> missions) {
        Map<String, Double> agent1Missions = new LinkedHashMap<>(missions.get(one));
        Map<String, Double> agent2Missions = new LinkedHashMap<>(missions.get(two));

        missions.get(one).clear();
        missions.get(two).clear();

        missions.get(two).putAll(agent1Missions);
        missions.get(one).putAll(agent2Missions);
    }

    private static void printMissions(Map<String, Map<String, Double>> agentMissions) {
        agentMissions.entrySet().stream()
                .filter(x -> x.getValue().size() != 0)
                .sorted((a, b) -> {
                    Double agentOne = a.getValue().values().stream().reduce(Double::sum).get();
                    Double agentTwo = b.getValue().values().stream().reduce(Double::sum).get();

                    return Double.compare(agentTwo, agentOne);

                }).forEach(agent -> {
                    Double agentRating = agent.getValue().values().stream().reduce(Double::sum).get();

                    System.out.printf("Agent: %s - Total Rating: %.2f%n", agent.getKey(), agentRating);

                    agent.getValue()
                            .entrySet()
                            .stream()
                            .sorted((n, b) -> b.getValue().compareTo(n.getValue()))
                            .forEach(mission ->
                                    System.out.printf(" - %s -> %.2f%n",
                                            mission.getKey(), mission.getValue()));
                });
    }
}
