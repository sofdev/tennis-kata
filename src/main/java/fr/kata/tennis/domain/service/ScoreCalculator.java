package fr.kata.tennis.domain.service;

import fr.kata.tennis.domain.model.Player;

public class ScoreCalculator implements TennisGame{


    private final Player playerA;
    private final Player playerB;

    public ScoreCalculator() {
        this.playerA = new Player("Player A");
        this.playerB = new Player("Player B");
    }

    @Override
    public void playerWinsPoint(char player) {
        if (player == 'A') {
            updateScore(playerA, playerB);
        } else if (player == 'B') {
            updateScore(playerB, playerA);
        }
    }

    private void updateScore(Player winner, Player opponent) {
        if (winner.getScore() == 40 && !opponent.isAdvantage()) {
            winner.setScore(winner.getScore() + 1);
        } else if (winner.getScore() == 40 && opponent.isAdvantage()) {
            opponent.setAdvantage(false);
        } else if (winner.getScore() == 30) {
            winner.setScore(40);
        } else if (winner.getScore() == 15) {
            winner.setScore(30);
        } else if (winner.getScore() == 0) {
            winner.setScore(15);
        } else if (winner.getScore() == 40 && opponent.getScore() == 40) {
            winner.setAdvantage(true);
        }
    }

    @Override
    public boolean isGameWon() {
        return playerA.getScore() > 40 || playerB.getScore() > 40;
    }

    @Override
    public String getScore() {
        if (isGameWon()) {
            return getWinner();
        }
        if (playerA.isAdvantage()) {
            return "Player A has advantage";
        } else if (playerB.isAdvantage()) {
            return "Player B has advantage";
        } else if (playerA.getScore() == 40 && playerB.getScore() == 40) {
            return "Deuce";
        }
        else {
            return "Player A : " + formatScore(playerA.getScore()) + " / Player B : " + formatScore(playerB.getScore());
        }
    }

    @Override
    public String getWinner() {
        if (playerA.getScore() > 40) {
            return "Player A wins the game";
        } else if (playerB.getScore() > 40) {
            return "Player B wins the game";
        }
        return "";
    }

    private String formatScore(int score) {
        return switch (score) {
            case 0 -> "0";
            case 15 -> "15";
            case 30 -> "30";
            case 40 -> "40";
            default -> "";
        };
    }
}
