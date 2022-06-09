package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, List<String> authors) {
        super(title, category);
        if(findDuplicates(authors).size() >= 1) {
            System.out.println("Your list has duplicate items.");
            return;
        }
        this.authors = authors;
    }

    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    public static Set<String> findDuplicates(List<String> listContainingDuplicates) {

        final Set<String> setToReturn = new HashSet<String>();
        final Set<String> set1 = new HashSet<String>();

        for (String yourInt : listContainingDuplicates) {
            if (!set1.add(yourInt)) {
                setToReturn.add(yourInt);
            }
        }
        return setToReturn;
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

    @Override
    public void printDetail(){
        System.out.print("Book: " + this.ID + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getCost() + " - ");
        for (int i = 0; i < authors.size(); i++){
            System.out.print(authors.get(i));
            if(i != authors.size() - 1) System.out.print(" & ");
        }
        System.out.println();
    }
}
