package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T02CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    public double getAverageSalary() {
        return this.employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    public void printDepartment(Department department) {
        department.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.getIfo()));
    }
}
