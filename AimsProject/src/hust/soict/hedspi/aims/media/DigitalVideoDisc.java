package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media{
    private String director;
    private int length;

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category) {
        super(title, category);
    }

    public DigitalVideoDisc(String title, String category, String director) {
        super(title, category);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean search(String string) {
        int count = 0;

        String sTitle[] = super.getTitle().split(" ");
        String getTitle[] = string.split(" ");
        for(int i = 0;  i < getTitle.length; i++){
            for(int j = 0; j < sTitle.length; j++){
                if(sTitle[j].equalsIgnoreCase(getTitle[i])){
                    count++;
                }
            }
        }

        if(count == getTitle.length)
            return true;
        return false;
    }

    @Override
    public void printDetail(){
        System.out.println("DVD: " + this.ID + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getCost());
    }
}
