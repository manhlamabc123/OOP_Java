package hust.soict.hedspi.aims.order;
import java.util.*;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.utils.MyDate;

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

//    public Media getALuckyItem(){
//        Random rd = new Random();
//        int luckyNumber = rd.nextInt(this.itemsOrdered.size());
//        int i = 0;
//        for(i = 0; i <  this.itemsOrdered.size(); i++){
//            if(i == luckyNumber){
//                this.itemsOrdered.get(i).setCost(0);
//                break;
//            }
//        }
//        return this.itemsOrdered.get(i);
//    }

    public void addItemToOrder(){
        Scanner userChoice = null;
        String input = null;
        Media media = null;
        System.out.print("What do you want to add? Book(1), Digital Video Disc(2), Compact Disc(3): ");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextLine()){
            case "1":
                this.addBook();
                break;
            case "2":
                this.addDigitalCompactDisc();
                System.out.print("Play? (Yes/No) ");
                userChoice = new Scanner(System.in);
                input = userChoice.nextLine();
                if (input.equalsIgnoreCase("No")) {
                    break;
                }
                else if (!input.equalsIgnoreCase("Yes")) {
                    System.out.println("Invalid Choice.");
                    break;
                }
                media = this.itemsOrdered.get(itemsOrdered.size() - 1);
                DigitalVideoDisc digitalVideoDisc = (DigitalVideoDisc)media;
                digitalVideoDisc.play();
                break;
            case "3":
                this.addCompactDisc();
                System.out.print("Play? (Yes/No) ");
                userChoice = new Scanner(System.in);
                input = userChoice.nextLine();
                if (input.equalsIgnoreCase("No")) {
                    break;
                }
                else if (!input.equalsIgnoreCase("Yes")) {
                    System.out.println("Invalid Choice.");
                    break;
                }
                media = this.itemsOrdered.get(itemsOrdered.size() - 1);
                CompactDisc compactDisc = (CompactDisc) media;
                compactDisc.play();
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

    private void addDigitalCompactDisc(){
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
            Media media = new DigitalVideoDisc(title, category, cost, length, director);
            this.addMedia(media);
            System.out.println("Add Digital Video Disc successfully!");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private void addCompactDisc(){
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
            System.out.print("Cost: ");
            sc = new Scanner(System.in);
            float cost = sc.nextFloat();
            System.out.print("Artist: ");
            sc = new Scanner(System.in);
            String artist = sc.nextLine();
            ArrayList<Track> tracks = new ArrayList<Track>();
            System.out.print("Number of track: ");
            sc = new Scanner(System.in);
            int number = sc.nextInt();
            for(int i = 0; i < number; i++){
                System.out.print(i + ". Title: ");
                sc = new Scanner(System.in);
                String trackTitle = sc.nextLine();
                System.out.print(i + ". Length: ");
                sc = new Scanner(System.in);
                int trackLength = sc.nextInt();
                Track newTrack = new Track(trackTitle, trackLength);
                tracks.add(newTrack);
            }
            Media media = new CompactDisc(title, category, cost, director, artist, tracks);
            this.addMedia(media);
            System.out.println("Add Compact Disc successfully!");
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
