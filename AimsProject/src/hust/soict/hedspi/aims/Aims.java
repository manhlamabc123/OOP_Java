package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class Aims {
    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu(){
        System.out.println("Order Management Application: ");
        System.out.println("------------------------------");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }
}
