package ch11.Page347;

// Song class with Comparable interface for sorting by title
class SongV3 implements Comparable<SongV3> {
    private String title;
    private String artist;
    private int bpm;

    // Define natural ordering by title
    public int compareTo(SongV3 s) {
        return title.compareTo(s.getTitle());
    }

    // Constructor to initialize song details
    SongV3(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    // Getters for song properties
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getBpm() {
        return bpm;
    }

    // Custom toString for readable output
    public String toString() {
        return title + ": " + artist;
    }
}