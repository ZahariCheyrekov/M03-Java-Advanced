package M03_JavaAdvanced.L08_Generics.Exercises.T10Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Tuple> tuples = new ArrayList<>();

        String[] lines = bufferedReader.readLine().split("\\s+");

        tuples.add(new Tuple(lines[0] + " " + lines[1], lines[2]));
        lines = bufferedReader.readLine().split("\\s+");
        tuples.add(new Tuple(lines[0], lines[1]));
        lines = bufferedReader.readLine().split("\\s+");
        tuples.add(new Tuple(Integer.parseInt(lines[0]), Double.parseDouble(lines[1])));

        tuples.forEach(System.out::println);
    }
}