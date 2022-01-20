package M03_JavaAdvanced.L09_IteratorsAndComparators.Lab.T04BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        int bookTitleResult = o1.getTitle().compareTo(o2.getTitle());

        if (bookTitleResult == 0) {
            return Integer.compare(o1.getYear(), o2.getYear());
        } else {
            return bookTitleResult;
        }
    }
}