package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class T01SumLines {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Zahari\\OneDrive\\Работен плот\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        String line = bufferedReader.readLine();

        while (line != null) {
            System.out.println(getLineSum(line));

            line = bufferedReader.readLine();
        }
    }

    private static Integer getLineSum(String txt) {
        int sum = 0;
        for (int i = 0; i < txt.length(); i++) {
            sum += txt.charAt(i);
        }
        return sum;
    }
}