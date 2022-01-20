package M03_JavaAdvanced.L09_IteratorsAndComparators.Exercises.T09LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCommands = Integer.parseInt(bufferedReader.readLine());
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < numberOfCommands; i++) {
            String[] lines = bufferedReader.readLine().split("\\s+");

            if(lines[0].equals("Add")){
                linkedList.addLast(Integer.parseInt(lines[1]));
            }
            else if(lines[0].equals("Remove")){
                linkedList.remove(Integer.parseInt(lines[1]));
            }
        }

        System.out.println(linkedList.getSize());
        linkedList.forEach(e -> System.out.printf("%s ", e));
    }
}