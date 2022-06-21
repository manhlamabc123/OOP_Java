package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestMediaCompareTo {
    public static void main(String[] args) {
        ArrayList<Media> collection = new ArrayList<Media>();

        Book book = new Book("Book of Moon");
        Book book01 = new Book("Book of Sun");
        Book book02 = new Book("Book of Secret");
        Book book03 = new Book("Book of Eternity");

        collection.add(book);
        collection.add(book01);
        collection.add(book02);
        collection.add(book03);

        Iterator iterator = collection.iterator();

        System.out.println("-----------------------------------");
        System.out.println("The DVDs currently in the order are: ");
        while (iterator.hasNext()) {
            System.out.println( ((Book)iterator.next()).getTitle() );
        }

        Collections.sort((List)collection);
        iterator = collection.iterator();

        System.out.println("---------------------------------");
        System.out.println("The DVDs in sorted order are: ");
        while (iterator.hasNext()){
            System.out.println( ((Book)iterator.next()).getTitle() );
        }
        System.out.println("----------------------------------------------");
    }
}
