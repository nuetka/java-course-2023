package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuoteClient {
    private static final Logger LOGGER = Logger.getLogger(QuoteClient.class.getName());
    private final Socket socket;

    public QuoteClient(Socket socket) {
        this.socket = socket;
    }

    public void startClient() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                LOGGER.info("Vanya: ");
                String userInput = scanner.nextLine();
                writer.println(userInput);

                String response = reader.readLine();
                LOGGER.info("Server: " + response);
            }

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error in the client:", e);
        }
    }
}
