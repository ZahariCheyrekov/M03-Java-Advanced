package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Exercises.T11SerializeCustomObject;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String destination = "C:\\Users\\Zahari\\Desktop\\Destination\\course.ser";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(destination));

        Course course = new Course("Programming Basics With Java", 250);

        objectOutputStream.writeObject(course);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(destination));

        Course myReturnedCourse = (Course) objectInputStream.readObject();

        System.out.println("Course name: " + myReturnedCourse.getName());
        System.out.println("Number of students: " + myReturnedCourse.getNumberOfStudents());
    }
}
