package edu.blackjack.model;

import java.time.LocalDateTime;
import java.util.List;

public class Game {
    private List<Round> rounds;
    private String absolutWinner;
    private String totalScore;
    private LocalDateTime gameStart;
    private LocalDateTime gameFinish;
}
