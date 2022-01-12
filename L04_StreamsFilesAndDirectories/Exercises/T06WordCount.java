package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class T06WordCount {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Zahari\\OneDrive\\Работен плот\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        List<String> searchedWords = Arrays.asList(bufferedReader.readLine().split("\\s+"));

        Map<String, Long> words = new LinkedHashMap<>();

        bufferedReader = new BufferedReader(new FileReader(path));
        String line = bufferedReader.readLine();

        while (line != null) {
            String[] currentWords = line.split("\\s+");

            for (String currentWord : currentWords) {
                if (searchedWords.contains(currentWord)) {
                    if (!words.containsKey(currentWord)) {
                        words.put(currentWord, 1L);
                    } else {
                        words.put(currentWord, words.get(currentWord) + 1);
                    }
                }
            }
            line = bufferedReader.readLine();
        }

        words.entrySet()
                .stream()
                .sorted((frequency1, frequency2) -> frequency2.getValue()
                        .compareTo(frequency1.getValue()))
                .forEach(entry -> System.out.printf("%s - %s", entry.getKey(), entry.getValue()));
    }
}
