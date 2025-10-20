package ch17.Connections;

// File: Server.java
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        // Create a server socket listening on port 5000
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started. Waiting for client...");

        // Wait for a client to connect
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        // Create a writer to send data to the client
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Send a welcome message to the client
        out.println("Hello from the server!");

        // Close the client and server sockets
        clientSocket.close();
        serverSocket.close();
    }
}
