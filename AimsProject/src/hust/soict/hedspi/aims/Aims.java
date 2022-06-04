package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.Order;

import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        Scanner userChoice = new Scanner(System.in);
        boolean orderIsCreated = false;
        String input;
        Order order = null;

        while (true) {
            showMenu();
            switch (userChoice.nextInt()) {
                case 1:
                    order = new Order();
                    orderIsCreated = true;
                    System.out.println("Order Created Successfully.");
                    break;
                case 2:
                    if (orderIsCreated) {
                        while (true) {
                            order.addItemToOrder();
                            System.out.print("Continue adding? (Yes/No): ");
                            userChoice = new Scanner(System.in);
                            input = userChoice.nextLine();
                            if (input.equalsIgnoreCase("No")) {
                                break;
                            }
                            else if (!input.equalsIgnoreCase("Yes")) {
                                System.out.println("Invalid Choice.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Order haven't been created.");
                    }
                    break;
                case 3:
                    if (orderIsCreated) {
                        while (true) {
                            order.deleteById();
                            System.out.print("Continue deleting? (Yes/No): ");
                            userChoice = new Scanner(System.in);
                            input = userChoice.nextLine();
                            if (input.equalsIgnoreCase("No")) {
                                break;
                            } else if (!input.equalsIgnoreCase("Yes")) {
                                System.out.println("Invalid Choice.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Order haven't been created.");
                    }
                    break;
                case 4:
                    if (orderIsCreated) {
                        order.print();
                    } else {
                        System.out.println("Order haven't been created.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Input Error!");
                    break;
            }
        }
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
