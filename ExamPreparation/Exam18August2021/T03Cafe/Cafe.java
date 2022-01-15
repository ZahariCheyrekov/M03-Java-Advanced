package M03_JavaAdvanced.ExamPreparation.Exam18August2021.T03Cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public int getCount() {
        return this.employees.size();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getName() {
        return this.name;
    }

    public boolean removeEmployee(String name) {
        return this.employees
                .removeIf(employee -> employee.getName().equals(name));
    }

    public Employee getEmployee(String name) {
        return this.employees
                .stream()
                .filter(employee -> employee.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void addEmployee(Employee employee) {
        if (this.getCount() < this.getCapacity()) {
            this.employees.add(employee);
        }
    }

    public Employee getOldestEmployee() {
        Employee emp = null;
        int maxAge = Integer.MIN_VALUE;

        for (Employee employee : this.employees) {
            if (employee.getAge() > maxAge) {
                maxAge = employee.getAge();
                emp = employee;
            }
        }

        return emp;
    }

    public String report() {
        StringBuilder out = new StringBuilder();

        out.append(String.format("Employees working at Cafe %s:"
                , this.getName()))
                .append(System.lineSeparator());

        for (Employee employee : this.employees) {
            out.append(employee.toString())
                    .append(System.lineSeparator());
        }

        return out.toString();
    }
}