package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class T02SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Zahari\\OneDrive\\Работен плот\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = bufferedReader.readLine();

        Long sum = 0L;
        while (line != null) {
            sum += getLineSum(line);

            line = bufferedReader.readLine();
        }

        System.out.println(sum);
    }

    private static Long getLineSum(String txt) {
        long sum = 0L;

        for (int i = 0; i < txt.length(); i++) {
            sum += txt.charAt(i);
        }

        return sum;
    }
}