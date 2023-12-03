package edu.hw8.Task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuoteServer {

    private QuoteServer() {

    }

    private static final Logger LOGGER = Logger.getLogger(QuoteServer.class.getName());
    private static final int PORT = 12345;
    private static final int MAX_CONNECTIONS = 10;

    @SuppressWarnings("uncommentedmain")
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_CONNECTIONS);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            LOGGER.info("Server is running. Waiting for connections...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error:", e);
        } finally {
            executorService.shutdown();
        }
    }
}
