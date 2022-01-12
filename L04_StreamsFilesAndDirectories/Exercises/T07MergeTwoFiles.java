package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Exercises;

import java.io.*;

public class T07MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Zahari\\OneDrive\\Работен плот\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\inputOne.txt";

        String path2 = "C:\\Users\\Zahari\\OneDrive\\Работен плот\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\inputTwo.txt";

        String output = "C:\\Users\\Zahari\\OneDrive\\Работен плот\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\out.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        PrintWriter printWriter = new PrintWriter(new FileWriter(output));

        StringBuilder resultTxt = new StringBuilder();

        resultTxt.append(getText(bufferedReader));

        bufferedReader = new BufferedReader(new FileReader(path2));

        resultTxt.append(getText(bufferedReader));

        printWriter.print(resultTxt);

        printWriter.flush();

    }

    private static String getText(BufferedReader bufferedReader) throws IOException {
        String line = bufferedReader.readLine();

        StringBuilder builder = new StringBuilder();
        while (line != null) {
            builder.append(line).append("\n");
            line = bufferedReader.readLine();
        }
        return builder.toString();
    }
}