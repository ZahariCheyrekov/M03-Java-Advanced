package M03_JavaAdvanced.L08_IteratorsAndComparators.Lab.T04BookComparator;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

        // Sort is accepting comparator, BookComparator is implementing a comparator<Book> which has the
        // Compare((Book b1, Book b2) -> {}) method
        books.sort(new BookComparator());

        for (Book book : books) {
            System.out.println(book.getTitle() + book.getYear());
        }
    }
}