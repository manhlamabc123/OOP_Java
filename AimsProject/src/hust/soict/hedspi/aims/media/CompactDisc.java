package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title, String category, float cost, int length, String director, String artist, ArrayList<Track> tracks) {
        super(title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track already in Tracks.");
            return;
        }

        tracks.add(track);
        System.out.println("Add track successfully.");
    }

    public void removeTrack(Track track) {
        if(!tracks.contains(track)) {
            System.out.println("Track is not in Tracks.");
            return;
        }

        tracks.remove(track);
        System.out.println("Remove track successfully.");
    }

    @Override public int getLength() {
        return tracks.stream().mapToInt(Track::getLength).sum();
    }
}