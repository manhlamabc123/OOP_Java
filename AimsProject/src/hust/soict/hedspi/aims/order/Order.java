package hust.soict.hedspi.aims.order;
import java.util.ArrayList;
import java.util.Random;

import hust.soict.hedspi.aims.utils.MyDate;
import hust.soict.hedspi.aims.media.Media;

import java.util.Date;

public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    private MyDate orderDate;
    private static int nbOrders = 0;
    public static final int MAX_LIMITED_ORDERS = 5;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public Order() {
        if (nbOrders >= MAX_LIMITED_ORDERS) {
            System.out.println("Reached number orders limit.");
            return;
        }
        Date today = new Date();
        this.orderDate = new MyDate(today.getDate(), today.getMonth() + 1, today.getYear() + 1900);
        nbOrders++;
    }

    public void addMedia(Media media) {
        itemsOrdered.add(media);
        System.out.println("Added " + media.getTitle() + " successfully.");
    }

    public void removeMedia(Media media) {
        itemsOrdered.remove(media);
        System.out.println("Removed " + media.getTitle() + " successfully.");
    }

    public float totalCost() {
        float total = 0;

        for (int i=0; i < this.itemsOrdered.size(); i++) {
            total += itemsOrdered.get(i).getCost();
        }

        return total;
    }

    public void print() {
        System.out.println("Date: " + orderDate.getDay() + "/" + orderDate.getMonth() + "/" + orderDate.getYear() + ".");
        System.out.println("Ordered Items:");
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". DVD - " + this.itemsOrdered.get(i).getTitle() + " - " + this.itemsOrdered.get(i).getCategory() + ": " + this.itemsOrdered.get(i).getCost() + "$");
        }
        System.out.println("Total cost: " + totalCost());
    }

    public Media getALuckyItem(){
        Random rd = new Random();
        int luckyNumber = rd.nextInt(this.itemsOrdered.size());
        int i = 0;
        for(i = 0; i <  this.itemsOrdered.size(); i++){
            if(i == luckyNumber){
                this.itemsOrdered.get(i).setCost(0);
                break;
            }
        }
        return this.itemsOrdered.get(i);
    }
}
