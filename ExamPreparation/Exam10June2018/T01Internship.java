package M03_JavaAdvanced.ExamPreparation.Exam10June2018;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T01Internship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int problemsCount = Integer.parseInt(scanner.nextLine());
        int candidatesCount = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> problemsStack = new ArrayDeque<>();
        ArrayDeque<String> candidatesQueue = new ArrayDeque<>();

        for (int i = 0; i < problemsCount; i++) {
            String problem = scanner.nextLine();
            problemsStack.push(problem);
        }

        for (int i = 0; i < candidatesCount; i++) {
            String[] candidateName = scanner.nextLine().split("\\s+");

            if (candidateName.length == 2) {
                String firstName = candidateName[0];
                String lastName = candidateName[1];

                if (nameIsValid(firstName) && nameIsValid(lastName)) {
                    candidatesQueue.offer(firstName + " " + lastName);
                }
            }
        }

        while (candidatesQueue.size() > 1) {
            if (problemsStack.size() > 0) {
                String currentProblemToSolve = problemsStack.peek();
                String currentCandidate = candidatesQueue.peek();

                int problemSum = 0;
                int candidateSum = 0;
                for (int i = 0; i < currentProblemToSolve.length(); i++) {
                    problemSum += currentProblemToSolve.charAt(i);
                }

                for (int i = 0; i < currentCandidate.length(); i++) {
                    candidateSum += currentCandidate.charAt(i);
                }
                problemsStack.pop();

                if (candidateSum > problemSum) {
                    candidatesQueue.poll();
                    candidatesQueue.offer(currentCandidate);
                    System.out.printf("%s solved %s.%n", currentCandidate, currentProblemToSolve);
                } else {
                    problemsStack.addLast(currentProblemToSolve);
                    candidatesQueue.poll();
                    System.out.printf("%s failed %s.%n", currentCandidate, currentProblemToSolve);
                }

            } else {
                int count = candidatesQueue.size();

                for (String candidate : candidatesQueue) {
                    if (count > 1) {
                        System.out.print(candidate + ", ");
                        candidatesQueue.poll();
                        count--;

                    } else {
                        System.out.println(candidate);
                        candidatesQueue.poll();
                    }
                }
            }
        }

        if (candidatesQueue.size() == 1) {
            System.out.println(candidatesQueue.poll() + " gets the job!");
        }
    }

    private static boolean nameIsValid(String name) {
        boolean isValid = !Character.isLetter(name.charAt(0)) || Character.isUpperCase(name.charAt(0));

        for (int i = 1; i < name.length(); i++) {
            if (Character.isLetter(name.charAt(i)) && !Character.isLowerCase(name.charAt(i))) {
                isValid = false;
            }
        }
        return isValid;
    }
}