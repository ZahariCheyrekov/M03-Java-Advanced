package M03_JavaAdvanced.ExamPreparation.Exam16Dec2020.T03Openning;

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
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Employee: " + name + ", "
                + age + " (" + country + ")";
    }
}