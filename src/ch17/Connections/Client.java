package ch17.Connections;

// File: Client.java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        // Connect to the server on localhost at port 5000
        Socket socket = new Socket("localhost", 5000);

        // Create a reader to receive data from the server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Read a line of text sent by the server
        String message = in.readLine();

        // Print the received message
        System.out.println("Received from server: " + message);

        // Close the connection
        socket.close();
    }
}