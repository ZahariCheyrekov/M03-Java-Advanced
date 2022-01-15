package M03_JavaAdvanced.ExamPreparation.Exam18August2021.T03Cafe;

public class Employee {
    private String name;
    private int age;
    private String country;

    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getCountry() {
        return this.country;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s, %d from %s",
                this.getName(), this.getAge(), this.getCountry());
    }
}
