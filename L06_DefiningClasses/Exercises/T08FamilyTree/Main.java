package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T08FamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String infoAboutPerson = scanner.nextLine();

        Map<String, Person> byNamePerson = new LinkedHashMap<>();
        List<String> inputData = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {

            if (!input.contains(" - ")) {
                String name = input.substring(0, input.lastIndexOf(" "));
                String birthday = input.substring(input.lastIndexOf(" ") + 1);
                Person person = new Person(name, birthday);
                byNamePerson.put(name, person);
            } else {
                inputData.add(input);
            }
            input = scanner.nextLine();
        }

        for (String inputLine : inputData) {
            String parent = inputLine.split(" - ")[0];
            String child = inputLine.split(" - ")[1];

            if (!parent.contains("/")) {
                if (byNamePerson.containsKey(parent)) {
                    byNamePerson.get(parent).getChildren().add(child);
                }
            } else {
                for (Person personToFind : byNamePerson.values()) {
                    if (personToFind.getBirthday().equals(parent)) {
                        personToFind.getChildren().add(child);
                        break;
                    }
                }
            }
            //Add parent to the List with parents for Child
            if (!child.contains("/")) {
                if (byNamePerson.containsKey(child)) {
                    byNamePerson.get(child).getParents().add(parent);
                }
            } else {
                for (Person personToFind : byNamePerson.values()) {
                    if (personToFind.getBirthday().equals(child)) {
                        personToFind.getParents().add(parent);
                        break;
                    }
                }
            }
        }

        if (infoAboutPerson.contains("/")) {
            infoAboutPerson = getInfo(byNamePerson, infoAboutPerson);
            infoAboutPerson = infoAboutPerson.substring(0, infoAboutPerson.lastIndexOf(" "));
        }

        System.out.println(byNamePerson.get(infoAboutPerson).getName() + " " + byNamePerson.get(infoAboutPerson).getBirthday());
        System.out.println("Parents:");
        byNamePerson.get(infoAboutPerson).getParents().forEach(p -> System.out.println(getInfo(byNamePerson, p)));
        System.out.println("Children:");
        byNamePerson.get(infoAboutPerson).getChildren().forEach(p -> System.out.println(getInfo(byNamePerson, p)));

    }

    private static String getInfo(Map<String, Person> map, String someInfo) {
        String output = "";

        if (!someInfo.contains("/")) {
            output = someInfo + " " + map.get(someInfo).getBirthday();
        } else {
            for (Person personToFind : map.values()) {
                if (personToFind.getBirthday().equals(someInfo)) {
                    output = personToFind.getName() + " " + someInfo;
                    break;
                }
            }
        }
        return output;
    }
}