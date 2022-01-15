package M03_JavaAdvanced.ExamPreparation.Exam14April2021.T03University;

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
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public Student getStudent(String firstName, String lastName) {
        return this.students
                .stream()
                .filter(student -> student.getFirstName().equals(firstName) &&
                        student.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    public String dismissStudent(Student student) {
        StringBuilder dismiss = new StringBuilder();

        if (this.students.contains(student)) {
            dismiss.append("Removed student ")
                    .append(student.getFirstName())
                    .append(" ")
                    .append(student.getLastName());

            this.students.remove(student);

        } else {
            dismiss.append("Student not found");
        }

        return dismiss.toString();
    }

    public String registerStudent(Student student) {
        StringBuilder output = new StringBuilder();

        if (this.getStudentCount() < this.getCapacity()) {
            if (this.students.contains(student)) {
                output.append("Student is already in the university");

            } else {
                this.students.add(student);

                output.append("Added student")
                        .append(" ")
                        .append(student.getFirstName())
                        .append(" ")
                        .append(student.getLastName());

            }
        } else {
            output.append("No seats in the university");
        }

        return output.toString();
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