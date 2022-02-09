package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.capacity > this.students.size()) {
            if (this.students.contains(student)) {
                return "Student is already in the university";

            } else {
                this.students.add(student);

                return String.format("Added student %s %s",
                        student.getFirstName(), student.getLastName());
            }
        }
        return "No seats in the university";
    }

    public String dismissStudent(Student student) {
        if (this.students.contains(student)) {

            this.students.remove(student);

            return String.format("Removed student %s %s",
                    student.getFirstName(), student.getLastName());
        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName) {
        return this.students
                .stream()
                .filter(student -> student.getFirstName().equals(firstName) &&
                        student.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();

        this.students
                .forEach(student -> output
                        .append("==Student: First Name = ")
                        .append(student.getFirstName())
                        .append(", Last Name = ")
                        .append(student.getLastName())
                        .append(", Best Subject = ")
                        .append(student.getBestSubject())
                        .append(System.lineSeparator()));

        return output.toString();
    }
}
