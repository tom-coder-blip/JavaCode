package MyJavaProgram;  // This class belongs to the MoviePicker package

public class Movie implements Comparable<Movie> {  // Movie class can be compared to other Movie objects
    private final String title;   // Movie title
    private final String genre;   // Movie genre
    private final int runtime;    // Movie duration in minutes
    private final double rating;  // Movie rating out of 10

    // Constructor to set all fields when creating a Movie object
    public Movie(String title, String genre, int runtime, double rating) {
        this.title = title;
        this.genre = genre;
        this.runtime = runtime;
        this.rating = rating;
    }

    // Getter methods to access private fields
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getRuntime() { return runtime; }
    public double getRating() { return rating; }

    @Override
    public String toString() {
        // Returns a nice formatted string of the movie details
        return String.format("%s (%s) - %d min - %.1f/10", title, genre, runtime, rating);
    }

    @Override
    public int compareTo(Movie o) {
        // Compare movies by rating in descending order (highest first)
        return Double.compare(o.rating, this.rating);
    }

    @Override
    public boolean equals(Object o) {
        // Check if both objects are the same
        if (this == o) return true;
        // Check if the other object is a Movie
        if (!(o instanceof Movie)) return false;
        // Cast and compare title, genre, and runtime
        Movie m = (Movie)o;
        return title.equals(m.title) && genre.equals(m.genre) && runtime == m.runtime;
    }

    @Override
    public int hashCode() {
        // Generate a hash code using title, genre, and runtime
        return title.hashCode() ^ genre.hashCode() ^ runtime;
    }
}