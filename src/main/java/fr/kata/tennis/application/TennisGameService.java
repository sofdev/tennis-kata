package fr.kata.tennis.application;

import fr.kata.tennis.domain.service.TennisGame;

public class TennisGameService {

    private final TennisGame game;

    public TennisGameService(TennisGame game) {
        this.game = game;
    }

    public void processPoints(String points) {
        for (char point : points.toCharArray()) {
            game.playerWinsPoint(point);
            System.out.println(game.getScore());
            if (game.isGameWon()) {
                System.out.println(game.getWinner());
                break;
            }
        }
    }
}
