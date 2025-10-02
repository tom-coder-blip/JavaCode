package ch11.Page316;

public class SongV2 {
    private String title;
    private String artist;
    private int bpm;

    //constructor that sets the three fields when a SongV2 object is created.
    public SongV2(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getBpm() {
        return bpm;
    }

    public String toString() {
        return title;
    }
}

