package M03_JavaAdvanced.L08_IteratorsAndComparators.Exercises.T04Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> indexes = Arrays.stream(bufferedReader.readLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = bufferedReader.readLine();

        Lake lake = new Lake(indexes);

        StringBuilder stringBuilder = new StringBuilder();


        for (Integer index : lake) {
            stringBuilder.append(index).append(", ");
        }

        String output = stringBuilder.substring(0, stringBuilder.length() - 2);

        System.out.println(output);
    }
}