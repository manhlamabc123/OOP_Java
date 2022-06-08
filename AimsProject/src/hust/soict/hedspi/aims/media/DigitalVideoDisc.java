package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc{

    public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
        super(title, category, cost, length, director);
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
