package MyJavaProgram;

import javax.swing.*; // For GUI components like JFrame, JButton, JTextField, etc.
import java.awt.*; // For layout and drawing graphics (e.g., spinner)
import java.awt.event.*; // For handling button clicks (event listeners)
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Comparator;
import java.util.Collection;
import java.util.stream.Collectors; //filtering and sorting easily


public class Main {
    // List to store all movies
    private final List<Movie> movies = new ArrayList<>();
    // Model used to display movies in the JList
    private final DefaultListModel<Movie> listModel = new DefaultListModel<>();
    // List of sample movies to add randomly
    private final List<Movie> sampleMovies = new ArrayList<>();

    private JFrame frame;                // Main window
    private JList<Movie> movieJList;     // List to show movies
    private JTextField filterField;      // Text field for filtering
    private JLabel resultLabel;          // Label for spinner and result
    private Timer spinnerTimer;          // Timer for spinner animation (javax.swing.Timer)
    private int spinnerAngle = 0;        // Current spinner angle

    public static void main(String[] args) {
        // Start GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Main().createAndShowGui());
    }

    private void createAndShowGui() {
        loadSampleMovies(); // Load initial movies
        loadSampleMoviePool();

        frame = new JFrame("Tom's Movie Picker"); // Create main window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Create movie list UI
        movieJList = new JList<>(listModel);
        movieJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Top panel with filter
        JPanel top = new JPanel(new BorderLayout(6,6));
        filterField = new JTextField();
        JButton filterBtn = new JButton("Filter");
        filterBtn.addActionListener(e -> applyFilter()); // When clicked → filter movies
        top.add(new JLabel("Filter (genre or text):"), BorderLayout.WEST);
        top.add(filterField, BorderLayout.CENTER);
        top.add(filterBtn, BorderLayout.EAST);
        frame.add(top, BorderLayout.NORTH);

        // Add movie list with scroll
        frame.add(new JScrollPane(movieJList), BorderLayout.CENTER);

        // Bottom panel with buttons
        JPanel bottom = new JPanel();
        JButton pickBtn = new JButton("Random Pick");
        pickBtn.addActionListener(e -> pickRandomMovie()); // Random pick
        JButton addBtn = new JButton("Add Sample Movie");
        addBtn.addActionListener(e -> addSampleMovie());   // Add new movie
        JButton sortBtn = new JButton("Sort by Rating");
        sortBtn.addActionListener(e -> sortByRating());    // Sort movies

        // We will create a custom resultLabel below (with custom painting),
        // so don't add a plain placeholder here to avoid duplicate components.
        bottom.add(pickBtn);
        bottom.add(addBtn);
        bottom.add(sortBtn);

        // Timer for spinner animation (javax.swing.Timer)
        spinnerTimer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spinnerAngle = (spinnerAngle + 30) % 360; // Rotate spinner
                if (resultLabel != null) resultLabel.repaint();
            }
        });

        // Custom drawing for spinner (single label instance)
        resultLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                int w = getWidth();
                int h = getHeight();
                int cx = 10;
                int cy = h/2;
                g2.setStroke(new BasicStroke(3));
                g2.setColor(Color.GRAY);
                g2.drawOval(cx-8, cy-8, 16, 16); // outer circle
                g2.setColor(Color.BLUE);
                g2.rotate(Math.toRadians(spinnerAngle), cx, cy); // rotate line
                g2.drawLine(cx, cy, cx+8, cy); // spinner line
                g2.dispose();
            }
        };
        resultLabel.setPreferredSize(new Dimension(200,24));
        bottom.add(resultLabel);

        frame.add(bottom, BorderLayout.SOUTH);

        frame.setVisible(true); // Show window
        refreshList(movies);    // Display movies
    }

    private void loadSampleMovies() {
        movies.add(new Movie("The Matrix", "Sci-Fi", 136, 8.7));
        movies.add(new Movie("Spirited Away", "Animation", 125, 8.6));
        movies.add(new Movie("The Godfather", "Crime", 175, 9.2));
        movies.add(new Movie("Inception", "Sci-Fi", 148, 8.8));
        movies.add(new Movie("Parasite", "Thriller", 132, 8.6));
        movies.add(new Movie("The Dark Knight", "Action", 152, 9.0));
        movies.add(new Movie("Pulp Fiction", "Crime", 154, 8.9));
        movies.add(new Movie("Fight Club", "Drama", 139, 8.8));
        movies.add(new Movie("Forrest Gump", "Drama", 142, 8.8));
        movies.add(new Movie("Interstellar", "Sci-Fi", 169, 8.7));
        movies.add(new Movie("The Shawshank Redemption", "Drama", 142, 9.3));
        movies.add(new Movie("The Lord of the Rings: The Return of the King", "Fantasy", 201, 9.0));
        movies.add(new Movie("Gladiator", "Action", 155, 8.5));
        movies.add(new Movie("The Lion King", "Animation", 88, 8.5));
        movies.add(new Movie("Titanic", "Romance", 195, 7.9));
        movies.add(new Movie("Schindler's List", "History", 195, 9.0));
        movies.add(new Movie("Back to the Future", "Adventure", 116, 8.5));
        movies.add(new Movie("Avengers: Endgame", "Action", 181, 8.4));
        movies.add(new Movie("Joker", "Thriller", 122, 8.4));
        movies.add(new Movie("The Silence of the Lambs", "Thriller", 118, 8.6));
        movies.add(new Movie("Goodfellas", "Crime", 146, 8.7));
        movies.add(new Movie("Se7en", "Thriller", 127, 8.6));
        movies.add(new Movie("Saving Private Ryan", "War", 169, 8.6));
        movies.add(new Movie("The Green Mile", "Drama", 189, 8.6));
        movies.add(new Movie("The Prestige", "Mystery", 130, 8.5));
        movies.add(new Movie("Whiplash", "Drama", 106, 8.5));
        movies.add(new Movie("The Departed", "Crime", 151, 8.5));
        movies.add(new Movie("The Pianist", "Biography", 150, 8.5));
        movies.add(new Movie("Django Unchained", "Western", 165, 8.4));
        movies.add(new Movie("WALL·E", "Animation", 98, 8.4));
        movies.add(new Movie("Up", "Animation", 96, 8.3));
        movies.add(new Movie("Toy Story", "Animation", 81, 8.3));
        movies.add(new Movie("Finding Nemo", "Animation", 100, 8.2));
        movies.add(new Movie("The Avengers", "Action", 143, 8.0));
        movies.add(new Movie("Iron Man", "Action", 126, 7.9));
        movies.add(new Movie("Black Panther", "Action", 134, 7.3));
        movies.add(new Movie("Jurassic Park", "Adventure", 127, 8.2));
        movies.add(new Movie("The Terminator", "Action", 107, 8.1));
        movies.add(new Movie("Terminator 2: Judgment Day", "Action", 137, 8.6));
        movies.add(new Movie("Alien", "Horror", 117, 8.5));
        movies.add(new Movie("The Shining", "Horror", 146, 8.4));
        movies.add(new Movie("The Exorcist", "Horror", 122, 8.1));
        movies.add(new Movie("Psycho", "Horror", 109, 8.5));
        movies.add(new Movie("Casablanca", "Romance", 102, 8.5));
        movies.add(new Movie("La La Land", "Musical", 128, 8.0));
        movies.add(new Movie("The Truman Show", "Drama", 103, 8.2));
        movies.add(new Movie("The Social Network", "Biography", 120, 7.8));
        movies.add(new Movie("Coco", "Animation", 105, 8.4));
        movies.add(new Movie("Inside Out", "Animation", 95, 8.1));
        movies.add(new Movie("The Grand Budapest Hotel", "Comedy", 99, 8.1));
        movies.add(new Movie("Shutter Island", "Thriller", 138, 8.2));
    }

    private void loadSampleMoviePool() {
        sampleMovies.add(new Movie("Avatar", "Sci-Fi", 162, 7.8));
        sampleMovies.add(new Movie("Inglourious Basterds", "War", 153, 8.3));
        sampleMovies.add(new Movie("The Dark Knight Rises", "Action", 165, 8.4));
        sampleMovies.add(new Movie("The Wolf of Wall Street", "Biography", 180, 8.2));
        sampleMovies.add(new Movie("The Hunger Games", "Adventure", 142, 7.2));
        sampleMovies.add(new Movie("Frozen", "Animation", 102, 7.4));
        sampleMovies.add(new Movie("Deadpool", "Action", 108, 8.0));
        sampleMovies.add(new Movie("Doctor Strange", "Action", 115, 7.5));
        sampleMovies.add(new Movie("Guardians of the Galaxy", "Action", 121, 8.0));
        sampleMovies.add(new Movie("Logan", "Action", 137, 8.1));
        sampleMovies.add(new Movie("Cinderella", "Fantasy", 105, 7.0));
        sampleMovies.add(new Movie("The Revenant", "Adventure", 156, 8.0));
        sampleMovies.add(new Movie("Frozen II", "Animation", 103, 6.9));
        sampleMovies.add(new Movie("Tenet", "Sci-Fi", 150, 7.4));
        sampleMovies.add(new Movie("The Batman", "Action", 176, 7.9));
        sampleMovies.add(new Movie("Moana", "Animation", 107, 7.6));
        sampleMovies.add(new Movie("Encanto", "Animation", 102, 7.2));
        sampleMovies.add(new Movie("Soul", "Animation", 100, 8.0));
        sampleMovies.add(new Movie("1917", "War", 119, 8.2));
        sampleMovies.add(new Movie("Dune", "Sci-Fi", 155, 8.0));
    }

    private void refreshList(Collection<Movie> items) {
        // Clear list and display given items
        listModel.clear();
        items.forEach(listModel::addElement);
    }

    private void applyFilter() {
        // Get text from filter field
        String q = filterField.getText().trim().toLowerCase();
        // Filter movies by genre or title
        List<Movie> filtered = movies.stream()
                .filter(m -> m.getGenre().toLowerCase().contains(q)
                        || m.getTitle().toLowerCase().contains(q)
                        || q.isEmpty())
                .collect(Collectors.toList());
        refreshList(filtered);
    }

    private void pickRandomMovie() {
        // Create list of currently displayed movies
        List<Movie> current = new ArrayList<>();
        for (int i=0;i<listModel.getSize();i++) current.add(listModel.getElementAt(i));
        // If list empty → show warning
        if (current.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No movies to pick from. Try removing the filter or add movies.", "No movies", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Start spinner animation
        spinnerTimer.start();
        // Delay picking to show spinner (use javax.swing.Timer)
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spinnerTimer.stop();
                ((Timer)e.getSource()).stop();
                // Pick random movie
                Random rnd = new Random();
                Movie chosen = current.get(rnd.nextInt(current.size()));
                resultLabel.setText(" Picked: " + chosen.getTitle());
                // Show movie details
                JOptionPane.showMessageDialog(frame, chosen.toString(), "Your Pick", JOptionPane.INFORMATION_MESSAGE);
            }
        }).start();
    }

    private void addSampleMovie() {
        if (sampleMovies.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No more sample movies available!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Random rnd = new Random();
        Movie randomSample = sampleMovies.get(rnd.nextInt(sampleMovies.size())); //gets and adds random movie to the list

        // Avoid duplicates
        if (movies.contains(randomSample)) {
            JOptionPane.showMessageDialog(frame, "This movie is already in the list. Picking another...", "Duplicate", JOptionPane.WARNING_MESSAGE);
            sampleMovies.remove(randomSample); // Remove so it won’t repeat
            addSampleMovie(); // Try again recursively
            return;
        }

        movies.add(randomSample);
        sampleMovies.remove(randomSample); // Remove so the same movie isn’t picked twice
        applyFilter();
        resultLabel.setText(" Added: " + randomSample.getTitle());
    }

    private void sortByRating() {
        // Sort movies using compareTo (by rating)
        movies.sort(Comparator.naturalOrder());
        applyFilter();
    }
}