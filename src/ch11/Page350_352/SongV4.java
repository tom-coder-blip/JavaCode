package ch11.Page350_352;

// Song class with Comparable interface for sorting by title
class SongV4 implements Comparable<SongV4> {
    private String title;
    private String artist;
    private int bpm;

    // Define equality based on song title
    public boolean equals(Object aSong) {
        SongV4 other = (SongV4) aSong;
        return title.equals(other.getTitle());
    }

    // Hash code based on title for use in sets
    public int hashCode() {
        return title.hashCode();
    }

    // Natural ordering by title
    public int compareTo(SongV4 s) {
        return title.compareTo(s.getTitle());
    }

    // Constructor to initialize song details
    SongV4(String title, String artist, int bpm) {
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
        return title;
    }
}