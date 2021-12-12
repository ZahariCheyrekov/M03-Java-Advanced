package M03_JavaAdvanced.L08_Generics.Exercises.T08CustomListSorter;

import java.util.List;

public class Sorter {
    public static <T extends Comparable> void sort(CustomList<String> list) {
        List<String> sortedCollection = list.getCollection();
        sortedCollection.sort(Comparable::compareTo);
        list.setCollection(sortedCollection);
    }
}