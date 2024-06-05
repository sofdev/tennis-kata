package fr.kata.tennis.domain.model;

import lombok.Data;

@Data
public class Player {
    private final String name;
    private int score;
    private boolean advantage;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.advantage = false;
    }
}
