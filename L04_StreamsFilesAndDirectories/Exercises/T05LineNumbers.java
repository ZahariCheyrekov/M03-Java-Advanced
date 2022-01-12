package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class T05LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Zahari\\OneDrive\\Работен плот\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        String line = bufferedReader.readLine();

        int lineCounter = 1;

        while (line != null) {
            String text = lineCounter + ". " + line;
            System.out.println(text);

            lineCounter++;

            line = bufferedReader.readLine();
        }
    }
}
