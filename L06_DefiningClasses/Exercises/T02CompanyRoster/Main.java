package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T02CompanyRoster;

import java.util.*;
import java.util.regex.Pattern;

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
            String email = "n/a";
            int age = -1;

            Employee employee;

            if (data.length == 6) {
                email = data[4];
                age = Integer.parseInt(data[5]);

            } else if (data.length == 5) {
                String ageOrEmail = data[4];

                if (Pattern.matches("^[\\d]+$", ageOrEmail)) {
                    age = Integer.parseInt(ageOrEmail);
                } else {
                    email = ageOrEmail;
                }
            }

            employee = new Employee(name, salary, position, department, email, age);

            if (!departmentMap.containsKey(department)) {
                departmentMap.put(department, new Department(department));
            }
            departmentMap.get(department).getEmployees().add(employee);
        }

        Department department = getHighestAverageSalary(departmentMap);

        System.out.println("Highest Average Salary: " + department.getName());

        department.printDepartment(department);
    }

    private static Department getHighestAverageSalary(Map<String, Department> departmentMap) {
        return departmentMap
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();
    }
}
