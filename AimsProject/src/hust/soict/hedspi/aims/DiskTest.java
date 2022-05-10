package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

import java.util.Scanner;

public class DiskTest {
    public static void main(String[] args) {
        Order anOrder = new Order();
        //create a new dvd object and set the fields
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        //add the dvd to the order
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your title: ");
        String searchTitle = sc.nextLine();
        sc.close();
        if (dvd1.search(searchTitle)) {
            anOrder.getALuckyItem();
            anOrder.print();
        }
    }
}
