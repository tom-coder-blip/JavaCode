package ch12.SongListActivity;

public class Song {
    private final String title;
    private final String artist;
    private final String genre;
    private final int year;
    private final int timesPlayed;

    // Constructor initializes all Song fields
    public Song(String title, String artist, String genre, int year, int timesPlayed) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.timesPlayed = timesPlayed;
    }

    // Returns the song title
    public String getTitle() {
        return title;
    }

    // Returns the song artist
    public String getArtist() {
        return artist;
    }

    // Returns the song genre
    public String getGenre() {
        return genre;
    }

    // Returns the year the song was released
    public int getYear() {
        return year;
    }

    // Returns the number of times the song was played
    public int getTimesPlayed() {
        return timesPlayed;
    }

    // Returns a formatted string with all song details
    @Override
    public String toString() {
        return title + " by " + artist + " (" + genre + ", " + year + ") - Plays: " + timesPlayed;
    }
}