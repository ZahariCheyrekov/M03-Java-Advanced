package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class T07ListFiles {
    public static void main(String[] args) throws IOException {
        String path = ("C:\\Users\\Zahari\\OneDrive\\Работен плот\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        Files.list(Paths.get(path)).forEach(f -> {
            File file = f.toFile();
            if (file.isFile()) {
                System.out.printf("%s: [%s]%n", file.getName(), file.length());
            }
        });
    }
}