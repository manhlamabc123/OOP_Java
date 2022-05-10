package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.utils.MyDate;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

import java.util.Date;

public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    private int qtyOrdered = 0;
    private MyDate orderDate;
    private static int nbOrders = 0;
    public static final int MAX_LIMITED_ORDERS = 5;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public Order() {
        if (nbOrders >= MAX_LIMITED_ORDERS) {
            System.out.println("Reached number orders limit.");
            return;
        }
        Date today = new Date();
        this.orderDate = new MyDate(today.getDate(), today.getMonth() + 1, today.getYear() + 1900);
        nbOrders++;
    }

    private int arrayLength (DigitalVideoDisc [] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                count++;
            }
        }
        return count;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The order is full.");
            return;
        }

        if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
            System.out.println("The order is almost full.");
        }

        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("Order " + disc.getTitle() + " successfully.");
        return;
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) {
            System.out.println("The order is empty.");
            return;
        }

        int index = 0;
        for (int i = 0; i<qtyOrdered; i++) {
            if(itemsOrdered[i] == disc) {
                index = i;
                break;
            }
        }

        if(index == qtyOrdered - 1) qtyOrdered--;
        else {
            for (int i = index + 1; i<qtyOrdered; index++, i++) {
                itemsOrdered[index] = itemsOrdered[i];
            }
        }

        System.out.println("Remove " + disc.getTitle() + " successfully.");
        return;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        if (arrayLength(dvdList) + qtyOrdered > 10) {
            System.out.println("The order is full.");
            return;
        }

        for (int i = 0; i < arrayLength(dvdList); i++, qtyOrdered++) {
            itemsOrdered[qtyOrdered + 1] = dvdList[i];
            System.out.println("Added successfully: " + dvdList[i].getTitle());
        }
        return;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 1 > 10) {
            System.out.println("The order is full.");
            System.out.println("Cannot add: " + dvd1.getTitle());
            return;
        }
        this.addDigitalVideoDisc(dvd1);
        System.out.println("Added successfully: " + dvd1.getTitle());
        if (qtyOrdered + 1 > 10) {
            System.out.println("The order is full.");
            System.out.println("Cannot add: " + dvd2.getTitle());
            return;
        }
        this.addDigitalVideoDisc(dvd2);
        System.out.println("Added successfully: " + dvd2.getTitle());
    }

    public float totalCost() {
        float total = 0;

        for (int i=0; i<qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }

        return total;
    }

    public void print() {
        System.out.println("Date: " + orderDate.getDay() + "/" + orderDate.getMonth() + "/" + orderDate.getYear() + ".");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". DVD - " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength() + ": " + itemsOrdered[i].getCost() + "$");
        }
        System.out.println("Total cost: " + totalCost());
    }
}
