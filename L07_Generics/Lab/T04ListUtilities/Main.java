package M03_JavaAdvanced.L07_Generics.Lab.T04ListUtilities;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, 34, 5, 2, - 1);

        int getMax = ListUtilities.getMax(integers);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings,"a","b","c");

        String minString = ListUtilities.getMin(strings);

        System.out.println(getMax);
        System.out.println(minString);
    }
}