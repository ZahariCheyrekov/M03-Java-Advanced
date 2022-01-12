package M03_JavaAdvanced.L04_StreamsFilesAndDirectories.Exercises.T11SerializeCustomObject;

import java.io.Serializable;

public class Course implements Serializable {
    private String name;
    private Integer numberOfStudents;

    public Course(String name, Integer numberOfStudents) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(Integer numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
}