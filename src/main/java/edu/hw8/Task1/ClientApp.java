package edu.hw8.Task1;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientApp {

    private ClientApp() {

    }

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;
    private static final Logger LOGGER = Logger.getLogger(ClientApp.class.getName());

    @SuppressWarnings("uncommentedmain")
    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT)) {
            QuoteClient quoteClient = new QuoteClient(socket);
            quoteClient.startClient();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error:", e);
        }
    }
}
