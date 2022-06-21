package hust.soict.hedspi.aims.media;

public abstract class Media {
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
}