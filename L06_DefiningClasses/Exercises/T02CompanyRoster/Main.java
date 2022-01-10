package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T02CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Department> departmentMap = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];

            Employee employee;

            if (data.length == 6) {
                String email = data[4];
                int age = Integer.parseInt(data[5]);
                employee = new Employee(name, salary, position, department, email, age);

            } else if (data.length == 5) {
                String ageOrEmail = data[4];

                try {
                    int age = Integer.parseInt(ageOrEmail);
                    employee = new Employee(name, salary, position, department, age);

                } catch (NumberFormatException e) {
                    employee = new Employee(name, salary, position, department, ageOrEmail);
                }

            } else {
                employee = new Employee(name, salary, position, department);
            }

            if (!departmentMap.containsKey(department)) {
                departmentMap.put(department, new Department(department));
            }
            departmentMap.get(department).getEmployees().add(employee);
        }

        Department maxAverageSalaryDepartment = departmentMap
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment.getName());
        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.getIfo()));
    }
}