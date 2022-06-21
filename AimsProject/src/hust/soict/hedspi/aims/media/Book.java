package hust.soict.hedspi.aims.media;

import com.sun.jdi.Value;

import java.util.*;
import java.util.stream.Collectors;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    private String content;
    private List<String> contentTokens = new ArrayList<String>();
    private Map<String, Integer> wordFrequency = new HashMap<>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
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

    public void setContent(String content) {
        this.content = content;
        processContent();
    }

    public String getContent() {
        return content;
    }

    private void processContent(){
        String content = removePunctuations(this.getContent()).toLowerCase();
        content = content.replaceAll("\\s+"," ");
        String[] tokens = content.split(" ");
        Arrays.sort(tokens);

        int frequency = 1;
        for(int i=0; i<tokens.length; i++) {
            if(i == tokens.length - 1) {
                if(tokens[i].equals(tokens[i - 1])){
                    frequency++;
                    this.wordFrequency.put(tokens[i], frequency);
                    return;
                } else {
                    this.wordFrequency.put(tokens[i], 1);
                    return;
                }
            }
            if(tokens[i].equals(tokens[i+1])){
                frequency++;
            } else {
                this.wordFrequency.put(tokens[i], frequency);
                frequency = 1;
            }
            this.contentTokens.add(tokens[i]);
        }
    }

    @Override public String toString(){
        return "Book: " + this.ID + " - " + this.getTitle() + " - " + this.getCategory() + " - " +
                this.getCost() + " - " + this.authors.toString() + "\n" + this.getContent() + "\n" + this.contentTokens.toString() + "\n" + this.wordFrequency;
    }

    public static String removePunctuations(String source) {
        return source.replaceAll("\\p{Punct}|\\p{Space}", " ");
    }
}
