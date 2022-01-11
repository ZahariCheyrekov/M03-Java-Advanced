package M03_JavaAdvanced.L08_IteratorsAndComparators.Lab.T03ComparableBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(String... authors) {
        if (authors.length == 0) {
            this.authors = new ArrayList<>();
        } else {
            this.authors = Arrays.asList(authors);
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", this.getTitle(), this.getYear());
    }

    @Override
    public int compareTo(Book o) {
        int bookTitleResult = this.title.compareTo(o.title);
        if (bookTitleResult == 0) {
            return Integer.compare(this.year, o.year);
        } else {
            return bookTitleResult;
        }
    }
}
