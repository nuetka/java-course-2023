package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class ClientHandler implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(ClientHandler.class.getName());

    private final Socket clientSocket;

     ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String request = reader.readLine();
            String response = getQuote(request);
            writer.println(response);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error:", e);
        }
    }

    private String getQuote(String keyword) {
        return switch (keyword.toLowerCase()) {
            case "личности" -> "Не переходи на личности там, где их нет";
            case "оскорбления" ->
                    "Если твои противники перешли на личные оскорбления, будь уверен — "
                        + "твоя победа не за горами";
            case "глупый" ->
                    "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... "
                        + "Ты просто бог идиотизма.";
            case "интеллект" -> "Чем ниже интеллект, тем громче оскорбления";
            default -> "Не могу найти цитату для данного ключевого слова";
        };
    }
}
