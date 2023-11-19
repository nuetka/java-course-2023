package edu.hw6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    void test2() {
        HackerNews hackerNews = new HackerNews();
        long storyId = 37570037;
        String newsTitle = hackerNews.news(storyId);

        assertThat(newsTitle).isEqualTo("JDK 21 Release Notes");
    }

}
