package M03_JavaAdvanced.L09_IteratorsAndComparators.Exercises.T04Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {

    private List<Integer> indexes;

    public Lake(List<Integer> indexes) {
        this.indexes = indexes;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }


    private class Frog implements Iterator<Integer> {

        private int position;
        private int lastEvenIndex = indexes.size() % 2 == 0 ? indexes.size() - 2 : indexes.size() - 1;

        @Override
        public boolean hasNext() {
            return this.position < indexes.size();
        }

        @Override
        public Integer next() {
            int index = indexes.get(position);
            if (position == lastEvenIndex) {
                this.position = 1;
                return index;
            }
            position += 2;
            return index;
        }
    }
}