package edu.blackjack.model;

import sun.rmi.server.LoaderHandler;

import java.time.LocalDateTime;
import java.util.List;

public class Round {
    private String userName;
    private List<Card> delivery;
    private List<Card> deliveryPC;
    private Boolean isWin;
    private String score;
    private LocalDateTime start;
    private LocalDateTime finish;
}
