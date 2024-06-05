package fr.kata.tennis.infrastructure;

import fr.kata.tennis.application.TennisGameService;
import fr.kata.tennis.domain.service.ScoreCalculator;

public class ConsoleAdapter {

    public static void main(String[] args) {
        ScoreCalculator game = new ScoreCalculator();
        TennisGameService gameService = new TennisGameService(game);

        String points = "ABABAB";
        gameService.processPoints(points);
    }
}
