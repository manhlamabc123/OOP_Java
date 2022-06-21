package hust.soict.hedspi.test;

import hust.soict.hedspi.aims.media.Book;

import java.util.ArrayList;
import java.util.List;

public class BookTest {
    public static void main(String[] args) {
        List<String> authors = new ArrayList<String>();
        authors.add("Mario");
        authors.add("Luigi");
        authors.add("Wario");
        Book book = new Book("Book of Moon", "Category", 1000, authors);
        book.setContent("This is the book of Moon, no one can be allowed to read this book's content.");
        System.out.println(book.toString());
    }
}
