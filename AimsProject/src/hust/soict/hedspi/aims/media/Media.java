package hust.soict.hedspi.aims.media;

public class Media {
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getID() {
        return ID;
    }

    public void printDetail() {
        return;
    };
}