package fr.kata.tennis.domain.service;

public interface TennisGame {
    void playerWinsPoint(char player);
    boolean isGameWon();
    String getScore();
    String getWinner();
}
