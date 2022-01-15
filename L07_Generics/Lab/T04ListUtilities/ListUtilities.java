package M03_JavaAdvanced.L07_Generics.Lab.T04ListUtilities;

import java.util.Collections;
import java.util.List;

public class ListUtilities {
    private ListUtilities() {
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list!");
        }
        return Collections.max(list);
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list!");
        }
        return Collections.min(list);
    }
}