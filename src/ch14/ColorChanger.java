package ch14;

import javax.swing.*;       // Import Swing components for GUI
import java.awt.*;          // Import AWT classes for graphics
import java.awt.event.*;    // Import event classes for handling user actions

// This class extends JPanel and will be used to draw a colored circle
public class ColorChanger extends JPanel {
    Color circleColor = Color.BLUE;  // Initial color of the circle

    // This method is called automatically when the panel needs to be drawn or refreshed
    public void paintComponent(Graphics g) {
        super.paintComponent(g);     // Clears the panel before drawing
        g.setColor(circleColor);     // Set the drawing color
        g.fillOval(50, 50, 100, 100); // Draw a filled circle (oval) at x=50, y=50
    }

    // Main method to launch the GUI
    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Changer"); // Create a window with a title
        ColorChanger panel = new ColorChanger();    // Create an instance of our custom panel
        JButton button = new JButton("Change Color"); // Create a button labeled "Change Color"

        // Add an event listener to the button using a lambda expression
        button.addActionListener(e -> {
                panel.circleColor = Color.RED;  // Change the circle's color to red
                panel.repaint();                // Request the panel to redraw itself
        });

        // Add the panel to the center of the window
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        // Add the button to the bottom of the window
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.setSize(300, 300);            // Set the window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close app when window is closed
        frame.setVisible(true);            // Make the window visible
    }
}