package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Exercises;

import java.io.File;

public class T08GetFolderSize {
    public static void main(String[] args) {
        String path = "C:\\Users\\Zahari\\OneDrive\\Работен плот\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File[] files = new File(path).listFiles();
        long totalSize = 0L;

        assert files != null;
        for (File file : files) {
            if (file.isFile()) {
                totalSize += file.length();
            }
        }

        System.out.printf("Folder size: %s%n", totalSize);
    }
}