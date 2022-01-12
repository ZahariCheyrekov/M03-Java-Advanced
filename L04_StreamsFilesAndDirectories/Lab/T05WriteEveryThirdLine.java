package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Lab;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class T05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Zahari\\OneDrive\\Работен плот\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line = reader.readLine();

        int count = 1;
        while (line != null) {
            if (count % 3 == 0) {
                System.out.println(line);
            }

            line = reader.readLine();
            count++;
        }
    }
}