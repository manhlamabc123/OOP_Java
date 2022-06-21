package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.Playable;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override public boolean equals(Object o){
        if (!(o instanceof Track)) return false;
        Track track = (Track) o;
        if(this.getTitle().equals(((Track) o).getTitle()) && this.getLength() == ((Track) o).getLength()) return true;
        return false;
    }
}
