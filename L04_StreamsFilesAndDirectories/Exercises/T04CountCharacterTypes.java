package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Exercises;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class T04CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Zahari\\OneDrive\\Работен плот\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        List<Character> punctuations = Arrays.asList('!', ',', '.', '?');

        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuationCount = 0;

        int byteData = fileInputStream.read();

        while (byteData >= 0) {
            if ((char) byteData == ' ' || (char) byteData == '\n' || (char) byteData == '\r') {
                byteData = fileInputStream.read();
                continue;
            }

            if (vowels.contains((char) byteData)) {
                vowelsCount++;
            } else if (punctuations.contains((char) byteData)) {
                punctuationCount++;
            } else {
                consonantsCount++;
            }

            byteData = fileInputStream.read();
        }

        System.out.printf("Vowels: %s%n", vowelsCount);
        System.out.printf("Consonants: %s%n", consonantsCount);
        System.out.printf("Punctuation: %s%n", punctuationCount);
    }
}