package hust.soict.hedspi.aims.media;

public abstract class Media implements Comparable{
    private String title;
    private String category;
    private float cost;
    private static int tempID = -1;
    public int ID;

    public Media(String title) {
        tempID++;
        this.ID = tempID;
        this.title = title;
    }

    public Media(String title, String category) {
        tempID++;
        this.ID = tempID;
        this.title = title;
        this.category = category;
    }

    public Media(String title, String category, float cost) {
        tempID++;
        this.ID = tempID;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public int getID() {
        return ID;
    }

    public void printDetail() {}

    @Override public boolean equals(Object o){
        if (!(o instanceof Media)) return false;
        Media obj = (Media) o;
        if (this.getID() == obj.getID()) return true;
        return false;
    }

    @Override public int compareTo(Object obj){
        try {
            if(!(obj instanceof Book)) throw new Exception("Not the same Object.");
            Media media = (Media) obj;
            return this.getTitle().compareTo(media.getTitle());
        } catch (Exception exception) {
            System.out.println(exception.toString());
            return -1;
        }
    }
}