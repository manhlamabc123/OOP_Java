package hust.soict.hedspi.aims.order;
import java.util.*;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.utils.MyDate;
import hust.soict.hedspi.aims.media.Media;

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
            this.itemsOrdered.get(i).printDetail();
            System.out.println();
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

    public void addItemToOrder(){
        System.out.print("What do you want to add? Book or Disc: ");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextLine()){
            case "Book":
                this.addBook();
                break;
            case "Disc":
                this.addDisc();
                break;
            default:
                System.out.println("Invalid Choice.");
                break;
        }
    }

    private void addBook(){
        try {
            Scanner sc = null;
            System.out.print("Title: ");
            sc = new Scanner(System.in);
            String title = sc.nextLine();
            System.out.print("Category: ");
            sc = new Scanner(System.in);
            String category = sc.nextLine();
            System.out.print("Cost: ");
            sc = new Scanner(System.in);
            float cost = sc.nextFloat();
            System.out.print("Number of Author: ");
            List<String> authors = new ArrayList<String>();
            sc = new Scanner(System.in);
            int numberOfAuthor = sc.nextInt();
            for (int i = 0; i < numberOfAuthor; i++) {
                System.out.print("Author " + (i + 1) + ": ");
                sc = new Scanner(System.in);
                String name = sc.nextLine();
                authors.add(name);
            }
            Media book = new Book(title, category, cost, authors);
            this.addMedia(book);
            System.out.println("Add Book successfully!");

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private void addDisc(){
        try {
            Scanner sc = null;
            System.out.print("Title: ");
            sc = new Scanner(System.in);
            String title = sc.nextLine();
            System.out.print("Category: ");
            sc = new Scanner(System.in);
            String category = sc.nextLine();
            System.out.print("Director: ");
            sc = new Scanner(System.in);
            String director = sc.nextLine();
            System.out.print("Length: ");
            sc = new Scanner(System.in);
            int length = sc.nextInt();
            System.out.print("Cost: ");
            sc = new Scanner(System.in);
            float cost = sc.nextFloat();
            Media media = new DigitalVideoDisc(title, category, director, length, cost);
            this.addMedia(media);
            System.out.println("Add Disc successfully!");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void deleteById(){
        System.out.print("Insert ID: ");
        Scanner sc = new Scanner(System.in);
        int ID = sc.nextInt();
        Media mediaTemp = this.searchById(ID);
        if (mediaTemp == null) {
            System.out.println("Sorry, invalid ID");
        } else {
            this.removeMedia(mediaTemp);
            System.out.println("Removed successfully");
        }
    }

    public Media searchById(int ID){
        for (int i = 0; i < itemsOrdered.size(); i++){
            if (itemsOrdered.get(i).getID() == ID){
                return itemsOrdered.get(i);
            }
        }
        return null;
    }
}
