package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Exercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class T12CreateZipArchive {
    public static void main(String[] args) throws IOException {
        String locationOne = "C:\\Users\\Zahari\\Desktop\\Zip-Example\\first.txt";
        String locationTwo = "C:\\Users\\Zahari\\Desktop\\Zip-Example\\second.txt";
        String locationThree = "C:\\Users\\Zahari\\Desktop\\Zip-Example\\third.txt";
        String dest = "C:\\Users\\Zahari\\Desktop\\Zip-Example\\files.zip";

        FileInputStream fileInputStream = new FileInputStream(locationOne);

        byte[] firstFileBytes = fileInputStream.readAllBytes();
        fileInputStream = new FileInputStream(locationTwo);

        byte[] secondFileBytes = fileInputStream.readAllBytes();
        fileInputStream = new FileInputStream(locationThree);

        byte[] thirdFileBytes = fileInputStream.readAllBytes();

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(dest));

        zipOutputStream.putNextEntry(new ZipEntry("first.txt"));
        zipOutputStream.write(firstFileBytes);
        zipOutputStream.putNextEntry(new ZipEntry("second.txt"));
        zipOutputStream.write(secondFileBytes);
        zipOutputStream.putNextEntry(new ZipEntry("third.txt"));
        zipOutputStream.write(thirdFileBytes);
        zipOutputStream.flush();
        zipOutputStream.close();
    }
}