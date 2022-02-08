package cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addEmployee(Employee employee) {
        if (this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        return this.employees.removeIf(employee -> employee.getName().equals(name));
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

    public Employee getEmployee(String name) {
        return this.employees
                .stream()
                .filter(employee -> employee.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder message = new StringBuilder();

        message.append(String.format("Employees working at Cafe %s:", this.name)).append(System.lineSeparator());

        for (Employee employee : this.employees) {
            message.append(employee.toString())
                    .append(System.lineSeparator());
        }

        return message.toString();
    }
}
