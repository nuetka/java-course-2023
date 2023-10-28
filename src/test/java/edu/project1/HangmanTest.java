package edu.project1;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HangmanTest {

    @Test
    public void testEmptyDictionary() {
        List<String> words = Arrays.asList(" ", " ");
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ConsoleHangman hangman = new ConsoleHangman();
            hangman.run(words);
        });
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testInvalidStringLength() {
        assertThatThrownBy(() -> new Session("a ")).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("В заданной строке обнаружены небуквенные символы.");
    }

    @Test
    void testGameLossAfterMaxAttempts() {
        Session session = new Session("test");
        for (int i = 0; i < 4; i++) {
            assertThat(session.guess('a')).isInstanceOf(GuessResult.FailedGuess.class);
        }
        assertThat(session.guess('a')).isInstanceOf(GuessResult.Defeat.class);
    }

    @Test
    public void testWinResult() {
        Session game = new Session("pop");
        game.guess('p');
        GuessResult result = game.guess('o');
        assertThat(result).isInstanceOf(GuessResult.Win.class);
    }

    @Test
    void testGameStateUpdatesCorrectly() {
        Session session = new Session("test");
        GuessResult result = session.guess('t');
        assertThat(result).isInstanceOf(GuessResult.SuccessfulGuess.class);
        assertThat(result.getState()).isEqualTo(new char[] {'t', '*', '*', 't'});
        result = session.guess('e');
        assertThat(result).isInstanceOf(GuessResult.SuccessfulGuess.class);
        assertThat(result.getState()).isEqualTo(new char[] {'t', 'e', '*', 't'});
        result = session.guess('s');
        assertThat(result).isInstanceOf(GuessResult.Win.class);
        assertThat(result.getState()).isEqualTo(new char[] {'t', 'e', 's', 't'});
    }

    @Test
    public void testSuccessAndFalseGuess() {
        Session game = new Session("stay");
        GuessResult resultSuccess = game.guess('s');
        GuessResult resultFalse = game.guess('z');
        assertThat(resultSuccess).isInstanceOf(GuessResult.SuccessfulGuess.class);
        assertThat(resultFalse).isInstanceOf(GuessResult.FailedGuess.class);
    }

}

