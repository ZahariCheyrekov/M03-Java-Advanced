package M03_JavaAdvanced.ExamPreparation.MyExam;

import java.util.*;
import java.util.regex.Pattern;

public class T01FoodFinder {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayDeque<String> vowelsQueue = fillQueue();
        ArrayDeque<String> consonantsStack = fillStack();

        List<String> wordsToMatch = new ArrayList<>();
        wordsToMatch.add("pear");
        wordsToMatch.add("flour");
        wordsToMatch.add("pork");
        wordsToMatch.add("olive");

        while (!consonantsStack.isEmpty()) {
            char vowel = vowelsQueue.poll().charAt(0);
            char constant = consonantsStack.pop().charAt(0);

            for (int i = 0; i < wordsToMatch.size(); i++) {
                String word = wordsToMatch.get(i);

                for (int j = 0; j < word.length(); j++) {
                    char currentChar = word.charAt(j);

                    if (currentChar == vowel || currentChar == constant) {
                        word = word.replace(currentChar, '-');
                    }
                }

                wordsToMatch.remove(i);
                wordsToMatch.add(i, word);
            }

            vowelsQueue.offer(String.valueOf(vowel));
        }

        List<String> foundWords = new ArrayList<>();
        int count = 0;

        int index = 0;
        for (String word : wordsToMatch) {
            if (Pattern.matches("^[-]+$", word)) {

                if (index == 0) {
                    foundWords.add("pear");
                } else if (index == 1) {
                    foundWords.add("flour");
                } else if (index == 2) {
                    foundWords.add("pork");
                } else if (index == 3) {
                    foundWords.add("olive");
                }

                count++;
            }

            index++;
        }

        System.out.println("Words found: " + count);
        for (String word : foundWords) {
            System.out.println(word);
        }
    }

    private static ArrayDeque<String> fillQueue() {
        String[] numbers = readData();

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String box : numbers) {
            queue.offer(box);
        }

        return queue;
    }

    private static ArrayDeque<String> fillStack() {
        String[] numbers = readData();

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String box : numbers) {
            stack.push(box);
        }

        return stack;
    }

    private static String[] readData() {
        return scanner.nextLine().split("[,\\s]+");
    }
}