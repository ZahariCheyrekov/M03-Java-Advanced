package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;

public class T01ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Zahari\\OneDrive\\Работен плот\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int value = inputStream.read();

        while (value != -1) {
            System.out.print(Integer.toBinaryString(value) + " ");
            value = inputStream.read();
        }

        inputStream.close();
    }
}