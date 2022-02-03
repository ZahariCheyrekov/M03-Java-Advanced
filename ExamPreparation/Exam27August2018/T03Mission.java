package M03_JavaAdvanced.ExamPreparation.Exam27August2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T03Mission {
    private static List<String> encryptedMessages;
    private static StringBuilder stringBuilder;

    private static String completedMissionName;
    private static int completedMission;
    private static String failedMissionName;
    private static int failedMission;

    private static final Pattern patternMission = Pattern.compile("[A-Z]");
    private static final Pattern patternMissionName = Pattern.compile("[a-z]");
    private static final Pattern patternMissionPoints = Pattern.compile("[\\d]");

    private static Matcher matcher;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        encryptedMessages = new ArrayList<>();

        readMessages(scanner);

        boolean completed = false;
        for (String encrypted : encryptedMessages) {

            boolean isValid = checkMessage(encrypted);

            if (isValid) {

                if (encrypted.contains("C") || encrypted.contains("c")) {
                    completed = true;

                }

                if (encrypted.contains("X")) {
                    completed = false;
                }

                findNameMission(encrypted);

                int missionPoints = findPointsMission(encrypted);

                if (completed) {
                    if (missionPoints > completedMission) {
                        completedMission = missionPoints;
                        completedMissionName = stringBuilder.toString();
                    }

                } else {
                    if (missionPoints > failedMission) {
                        failedMission = missionPoints;
                        failedMissionName = stringBuilder.toString();
                    }
                }
            }
        }

        printMissions();
    }

    private static boolean checkMessage(String encrypted) {
        matcher = patternMission.matcher(encrypted);

        stringBuilder = new StringBuilder();

        while (matcher.find()) {
            String letter = matcher.group();

            switch (letter) {
                case "M":
                case "I":
                case "S":
                case "O":
                case "N":
                    stringBuilder.append(letter);
                    break;
            }
        }

        return stringBuilder.toString().contains("MISSION");
    }

    private static void findNameMission(String encrypted) {
        matcher = patternMissionName.matcher(encrypted);

        stringBuilder = new StringBuilder();

        while (matcher.find()) {
            String letter = matcher.group();
            stringBuilder.append(letter);
        }
    }

    private static int findPointsMission(String encrypted) {
        matcher = patternMissionPoints.matcher(encrypted);

        int missionPoints = 0;
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            missionPoints += number;
        }

        return missionPoints;
    }

    private static void readMessages(Scanner scanner) {
        String message = scanner.nextLine();
        while (!message.equals("Decrypt")) {

            encryptedMessages.add(message);
            message = scanner.nextLine();
        }
    }

    private static void printMissions() {
        System.out.printf("Completed mission %s with rating: %d%n", completedMissionName, completedMission);
        System.out.printf("Failed Mission %s with rating: %d%n", failedMissionName, failedMission);
    }
}