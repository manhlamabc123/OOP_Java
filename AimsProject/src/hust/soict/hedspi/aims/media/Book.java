package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();

    public Book() {}

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

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName){
        if(authors.contains(authorName)) {
            System.out.println("Already existed.");
            return;
        }

        authors.add(authorName);
        System.out.println("Added " + authorName + " successfully.");
    }

    public void removeAuthor(String authorName){
        if(!authors.contains(authorName)) {
            System.out.println("Can not found author.");
            return;
        }

        authors.remove(authorName);
        System.out.println("Deleted " + authorName + " successfully.");
    }
}
