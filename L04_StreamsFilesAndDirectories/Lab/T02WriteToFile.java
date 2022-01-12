package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

public class T02WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Zahari\\OneDrive\\Работен плот\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        Set<Character> punctuation = Set.of(',', '.', '!', '?');

        int value = inputStream.read();

        while (value != -1) {
            char current = (char) value;

            if (!punctuation.contains(current)) {
                System.out.print(current);
            }

            value = inputStream.read();
        }

        inputStream.close();
    }
}