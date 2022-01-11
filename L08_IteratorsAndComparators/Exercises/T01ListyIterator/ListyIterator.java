package M03_JavaAdvanced.L08_IteratorsAndComparators.Exercises.T01ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterator<String> {
    private List<String> collection;
    private int index;


    public ListyIterator() {
        this.collection = new ArrayList<>();
        this.index = 0;
    }

    public ListyIterator(String... strings) {
        this();
        this.collection = Arrays.asList(strings);
    }


    public void create(String[] lines) {
        for (int i = 1; i < lines.length; i++) {
            this.collection.add(lines[i]);
        }
    }

    public void print() {
        if (this.collection.isEmpty()) {
            System.out.println("Invalid Operation!");
            return;
        }

        System.out.println(this.collection.get(index));
    }

    public boolean move() {
        if (this.hasNext()) {
            this.next();
            return true;
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        if (this.index + 1 < this.collection.size()) {
            return true;
        }
        return false;
    }

    @Override
    public String next() {
        return this.collection.get(index++);
    }
}