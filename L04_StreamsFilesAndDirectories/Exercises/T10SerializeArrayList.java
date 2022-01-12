package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.util.ArrayList;

public class T10SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String destination = "C:\\Users\\Zahari\\Desktop\\Destination\\list.ser";

        ArrayList<String> strings = new ArrayList<>();

        strings.add("First item");
        strings.add("Second item");
        strings.add("Third item");


        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(destination));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(destination));

        objectOutputStream.writeObject(strings);

        ArrayList<String> myReturnedArrayList = (ArrayList<String>) objectInputStream.readObject();

        for (String txt : myReturnedArrayList) {
            System.out.println(txt);
        }
    }
}
