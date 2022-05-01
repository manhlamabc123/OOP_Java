package New_Package;

public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    private int qtyOrdered = 0;

    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

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

    public float totalCost() {
        float total = 0;

        for (int i=0; i<qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }

        return total;
    }
}
