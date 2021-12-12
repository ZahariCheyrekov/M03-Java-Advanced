package M03_JavaAdvanced.L01_StackAndQueues.Exercises;

import java.util.*;

public class T10Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robotsData = scanner.nextLine().split(";");

        Map<String, Integer> robots = new LinkedHashMap<>();
        getRobotsData(robotsData, robots);

        int[] startingTime = Arrays.stream(scanner.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();

        int startingTimeSeconds = getStartingTime(startingTime);

        ArrayDeque<String> products = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            products.offer(input);
            input = scanner.nextLine();
        }

        Map<String, Integer> robotsWorkingTime = new LinkedHashMap<>();
        getRobotsWorkingTime(robotsData, robotsWorkingTime);

        while (!products.isEmpty()) {
            startingTimeSeconds++;
            String currentProduct = products.poll();

            decreaseWorkingTime(robotsWorkingTime);

            boolean isAvailable = false;
            for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
                if (robot.getValue() == 0) {
                    System.out.println(robot.getKey() + " - " + currentProduct + getTakenTime(startingTimeSeconds));

                    robotsWorkingTime.put(robot.getKey(), robots.get(robot.getKey()));
                    robot.setValue(robots.get(robot.getKey()));
                    isAvailable = true;
                    break;
                }
            }
            if (!isAvailable) {
                products.offer(currentProduct);
            }
        }
    }

    private static void getRobotsData(String[] robotsData, Map<String, Integer> robots) {
        for (String robotsDatum : robotsData) {
            String[] data = robotsDatum.split("-");
            String robotName = data[0];
            int processingTime = Integer.parseInt(data[1]);

            robots.put(robotName, processingTime);
        }
    }

    private static int getStartingTime(int[] startingTime) {
        int hours = startingTime[0];
        int minutes = startingTime[1];
        int seconds = startingTime[2];

        return ((hours * 3600) + minutes * 60) + seconds;
    }

    private static void getRobotsWorkingTime(String[] robotsData, Map<String, Integer> robotsWorkingTime) {
        for (String robotsDatum : robotsData) {
            String[] data = robotsDatum.split("-");
            String robotName = data[0];

            robotsWorkingTime.put(robotName, 0);
        }
    }

    private static void decreaseWorkingTime(Map<String, Integer> robotsWorkingTime) {
        for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
            if (robot.getValue() > 0) {
                robotsWorkingTime.put(robot.getKey(), robot.getValue() - 1);
            }
        }
    }

    private static String getTakenTime(int startingTimeSeconds) {
        int hours = (startingTimeSeconds / 3600) % 24;
        int minutes = startingTimeSeconds % 3600 / 60;
        int seconds = startingTimeSeconds % 60;

        return String.format(" [%02d:%02d:%02d]", hours, minutes, seconds);
    }
}