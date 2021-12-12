package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Child> getChildren() {
        return children;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Pokemon> getPokemon() {
        return pokemons;
    }

    public StringBuilder getPersonInfo() {
        StringBuilder builder = new StringBuilder();

        builder.append("Company:").append(System.lineSeparator());
        if (company != null) {
            builder.append(company.companyInfo()).append(System.lineSeparator());
        }

        builder.append("Car:").append(System.lineSeparator());
        if (car != null) {
            builder.append(car.carInfo()).append(System.lineSeparator());
        }

        builder.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : pokemons) {
            builder.append(pokemon.toString()).append(System.lineSeparator());
        }

        builder.append("Parents:").append(System.lineSeparator());
        for (Parent parent : parents) {
            builder.append(parent.toString()).append(System.lineSeparator());
        }

        builder.append("Children:").append(System.lineSeparator());
        for (Child child : children) {
            builder.append(child.toString()).append(System.lineSeparator());
        }

        return builder;
    }
}