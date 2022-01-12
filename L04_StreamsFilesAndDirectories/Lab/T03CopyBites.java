package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;

public class T03CopyBites {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Zahari\\OneDrive\\Работен плот\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int value = inputStream.read();

        while (value != -1) {
            if (value != 10 && value != 32) {
                System.out.print(value);

            } else {
                System.out.print((char) value);
            }

            value = inputStream.read();
        }

        inputStream.close();
    }
}