package M03_JavaAdvanced.L09_IteratorsAndComparators.Lab.T04BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    public int compare(Book book1, Book book2) {
        return book1.compareTo(book2);
    }
}
