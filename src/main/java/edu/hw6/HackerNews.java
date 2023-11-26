package edu.hw6;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {
    private static final Logger LOGGER = Logger.getLogger(HackerNews.class.getName());
    private static final String TOP_STORIES_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String ITEM_URL = "https://hacker-news.firebaseio.com/v0/item/%d.json";

    public long[] hackerNewsTopStories() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(TOP_STORIES_URL))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();
            String[] storyIds = responseBody.replace("[", "").replace("]", "").split(",");

            long[] ids = new long[storyIds.length];
            for (int i = 0; i < storyIds.length; i++) {
                ids[i] = Long.parseLong(storyIds[i].trim());
            }

            return ids;
        } catch (IOException | InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Failed to retrieve top stories", e);
            return new long[0];
        }
    }

    public String news(long id) {
        try {
            String itemUrl = String.format(ITEM_URL, id);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(itemUrl))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();
            Pattern pattern = Pattern.compile("\"title\"\\s*:\\s*\"(.*?)\"");
            Matcher matcher = pattern.matcher(responseBody);

            if (matcher.find()) {
                return matcher.group(1);
            } else {
                return "Title not found";
            }
        } catch (IOException | InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Failed to retrieve news", e);
            return "Error";
        }
    }
}
