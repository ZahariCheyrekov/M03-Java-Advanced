package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;

public class T08NestedLoops {
    public static void main(String[] args)throws IOException {
        String path = ("C:\\Users\\Zahari\\OneDrive\\Работен плот\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File folder = new File(path);

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.addFirst(folder);

        int folderCount = 0;

        while (!queue.isEmpty()) {
            File currentFile = queue.poll();

            if (currentFile.isDirectory()) {
                System.out.println(currentFile.getName());
                queue.addAll(Arrays.asList(Objects.requireNonNull(currentFile.listFiles())));
                folderCount++;
            }
        }

        System.out.printf("%s folders", folderCount);
    }
}