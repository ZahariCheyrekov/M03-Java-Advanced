package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T07Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> people = new HashMap<>();

        String input = reader.readLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String name = data[0];
            String typeData = data[1];

            people.putIfAbsent(name, new Person());

            switch (typeData) {
                case "company":
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);

                    Company company = new Company(companyName, department, salary);
                    people.get(name).setCompany(company);
                    break;

                case "pokemon":
                    String pokemonName = data[2];
                    String type = data[3];

                    Pokemon pokemon = new Pokemon(pokemonName, type);
                    people.get(name).getPokemon().add(pokemon);
                    break;

                case "parents":
                    String parentName = data[2];
                    String birthday = data[3];

                    Parent parent = new Parent(parentName, birthday);
                    people.get(name).getParents().add(parent);
                    break;

                case "children":
                    String childName = data[2];
                    String childBirthday = data[3];

                    Child child = new Child(childName, childBirthday);
                    people.get(name).getChildren().add(child);
                    break;

                case "car":
                    String carModel = data[2];
                    int speed = Integer.parseInt(data[3]);

                    Car car = new Car(carModel, speed);
                    people.get(name).setCar(car);
                    break;
            }
            input = reader.readLine();
        }
        String searchedPerson = reader.readLine();
        System.out.println(searchedPerson);

        Person person = people.get(searchedPerson);
        System.out.println(person.getPersonInfo());
    }
}