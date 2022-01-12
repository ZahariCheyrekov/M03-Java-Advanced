package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class T04ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Zahari\\OneDrive\\Работен плот\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                System.out.println(number);
            }
            scanner.next();
        }

        inputStream.close();
    }
}