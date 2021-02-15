package edu.blackjack.service;

import edu.blackjack.data.Data;
import edu.blackjack.model.Card;
import edu.blackjack.model.Player;
import edu.blackjack.model.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BlackJackService {

    @Autowired
    Data data;
    List<Card> deck = new ArrayList<>();
    boolean isStop = false;
    List<Card> delivery = new ArrayList<>();
    List<Card> forPC = new ArrayList<>();
    public int counterPlayer = 0;
    public int counterPC = 0;
    public int round = 1;
    public int roundCounter = 1;

    @PostConstruct
    public void init() {
        deck = new ArrayList<>(data.getDeck());
    }

    public void setScore(boolean youWin){
        if (youWin == true){
            counterPlayer ++;
        }else {
            counterPC ++;
        }
    }

    public List<Card> getShuffleDeck() {
        Collections.shuffle(deck);
        return deck;
    }

    public void playNext(){
        delivery = new ArrayList<>();
        forPC = new ArrayList<>();
    }
    public void newGame(){
        delivery = new ArrayList<>();
        forPC = new ArrayList<>();
        deck = new ArrayList<>();
        deck = data.getDeck();
        counterPC = 0;
        counterPlayer = 0;
        roundCounter = 1;
    }
    public int getDeckSize(){
        return deck.size();
    }

    public Card pickFirstCardFromShuffledDeck() {
        Card card = this.getShuffleDeck().get(0);
        deck.remove(card);//Удилить эту карту из колоды !!
        return card;
    }

    public List<Card> getCardList() {
        if (!isStop || delivery.stream().mapToInt(Card::getValue).sum()<=20){
            //delivery.stream().mapToInt(Card::getValue).sum()<=20
            Card card = this.pickFirstCardFromShuffledDeck();
            delivery.add(card);// выдать эту карту на роздачу !
        }
        return delivery;
    }

    public Player InitPlayer(Player player) {
        player.getPrivateSet().clear();
        return player;

    }

    public int getPlayerSum(Player player) {
        List<Card> cards = player.getPrivateSet();
        return cards.stream().mapToInt(Card::getValue).sum();
    }

    public Card showSixPike() {
        Card sixPike = deck.get(4);
        return sixPike;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public List<Card> getDelivery() {
        return delivery;
    }

    public List<Card> getDeliveryForPC() {
        for (int i = 0; i < 3; i++) {
            if (forPC.size()<3){
                Card card = this.pickFirstCardFromShuffledDeck();
                forPC.add(card);
            }
        }

        return forPC;
    }
    public String getWinner(int sum,int sum2) {
        String youWin = "You are Winnner";
        String loser = "You are losser";
        String draw = "Draw";
        String message = "";
        isStop = true;

        if (sum == sum2) {
            message = draw;
        } else {
            if (sum == 21 && sum2 != 21) {
                message = youWin;
            } else {
                if (sum < 21 && sum2 > 21) {
                    message = youWin;
                } else {
                    if (sum < 21 && sum2 < 21 && sum > sum2) {
                        message = youWin;
                    } else {
                        if (sum < 21 && sum2 < 21 && sum < sum2) {
                            message = loser;
                        } else {
                            if (sum > 21 && sum2 > 21 && sum < sum2) {
                                message = youWin;
                            } else {
                                if (sum > 21 && sum2 > 21 && sum > sum2) {
                                    message = loser;
                                }else {
                                    if (sum > 21 && sum2 < 21){
                                        message = loser;
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
        if (message.equals(youWin)){
            this.setScore(true);
        }else {
            this.setScore(false);
        }
        round ++;
        return message;
    }
}
