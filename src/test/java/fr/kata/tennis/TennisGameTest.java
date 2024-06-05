package fr.kata.tennis;

import fr.kata.tennis.domain.service.ScoreCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TennisGameTest {

    @Test
    void testPlayerAWins() {
        ScoreCalculator game = new ScoreCalculator();
        game.playerWinsPoint('A');
        game.playerWinsPoint('B');
        game.playerWinsPoint('A');
        game.playerWinsPoint('B');
        game.playerWinsPoint('A');
        game.playerWinsPoint('A');

        assertEquals("Player A wins the game", game.getScore());
    }

    @Test
    void testDeuce() {
        ScoreCalculator game = new ScoreCalculator();
        game.playerWinsPoint('A');
        game.playerWinsPoint('A');
        game.playerWinsPoint('A');
        game.playerWinsPoint('B');
        game.playerWinsPoint('B');
        game.playerWinsPoint('B');

        assertEquals("Deuce", game.getScore());
    }

    @Test
    void testAdvantageA() {
        ScoreCalculator game = new ScoreCalculator();
        game.playerWinsPoint('A');
        game.playerWinsPoint('A');
        game.playerWinsPoint('A');
        game.playerWinsPoint('B');
        game.playerWinsPoint('B');
        game.playerWinsPoint('B');
        game.playerWinsPoint('A');

        assertEquals("Player A has advantage", game.getScore());
    }

    @Test
    void testAdvantageB() {
        ScoreCalculator game = new ScoreCalculator();
        game.playerWinsPoint('A');
        game.playerWinsPoint('A');
        game.playerWinsPoint('A');
        game.playerWinsPoint('B');
        game.playerWinsPoint('B');
        game.playerWinsPoint('B');
        game.playerWinsPoint('B');

        assertEquals("Player B has advantage", game.getScore());
    }

    @Test
    void testBackToDeuce() {
        ScoreCalculator game = new ScoreCalculator();
        game.playerWinsPoint('A');
        game.playerWinsPoint('A');
        game.playerWinsPoint('A');
        game.playerWinsPoint('B');
        game.playerWinsPoint('B');
        game.playerWinsPoint('B');
        game.playerWinsPoint('A');
        game.playerWinsPoint('B');

        assertEquals("Deuce", game.getScore());
    }

    @Test
    void testPlayerBWinsAfterDeuce() {
        ScoreCalculator game = new ScoreCalculator();
        game.playerWinsPoint('A');
        game.playerWinsPoint('A');
        game.playerWinsPoint('A');
        game.playerWinsPoint('B');
        game.playerWinsPoint('B');
        game.playerWinsPoint('B');
        game.playerWinsPoint('B');
        game.playerWinsPoint('A');
        game.playerWinsPoint('B');
        game.playerWinsPoint('B');

        assertEquals("Player B wins the game", game.getScore());
    }

}
