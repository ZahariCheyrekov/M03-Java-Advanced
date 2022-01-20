package M03_JavaAdvanced.L08_Generics.Exercises.T03GenericSwapMethodString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Box<String> box = new Box<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            box.getCollection().add(reader.readLine());
        }
        int[] indexes = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Box.swapper(box.getCollection(), indexes[0], indexes[1]);
        System.out.println(box);
    }
}