package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestMediaCompareTo {
    public static void main(String[] args) {
        List<Media> collection = new ArrayList<Media>();

        Book book = new Book("Book of Moon", "Category", 1000);
        Book book01 = new Book("Book of Sun", "Category", 5000);
        Book book02 = new Book("Book of Secret", "Category", 4000);
        Book book03 = new Book("Book of Eternity", "Category", 3500);

        collection.add(book);
        collection.add(book01);
        collection.add(book02);
        collection.add(book03);

        Iterator iterator = collection.iterator();

        System.out.println("-----------------------------------");
        System.out.println("The DVDs currently in the order are: ");
        Book nowBook = null;
        while (iterator.hasNext()) {
            nowBook = (Book)iterator.next();
            System.out.println( nowBook.getTitle() + ": " + nowBook.getCost());
        }

        Collections.sort((List)collection);
        iterator = collection.iterator();

        System.out.println("---------------------------------");
        System.out.println("The DVDs in sorted order are: ");
        while (iterator.hasNext()){
            nowBook = (Book)iterator.next();
            System.out.println( nowBook.getTitle() + ": " + nowBook.getCost());
        }
        System.out.println("----------------------------------------------");
    }
}
