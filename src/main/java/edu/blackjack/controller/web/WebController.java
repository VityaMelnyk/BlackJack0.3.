package edu.blackjack.controller.web;

import edu.blackjack.model.Round;
import edu.blackjack.service.BlackJackService;
import edu.blackjack.model.Card;
import edu.blackjack.service.round.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

@Controller
@RequestMapping("/web/cards")
public class WebController {
    @Autowired
    BlackJackService service;
    private ToIntFunction<? super Card> card;

    @Autowired
    RoundService roundService;
    Round round;

    @RequestMapping("/game")
    public String showTable(Model model) {
        List<Card> delivery = new ArrayList<>();
        service.playNext();
        int roundCounter = service.roundCounter;
        round = RoundService.initRound();

        model.addAttribute("round", roundCounter);
        model.addAttribute("delivery", delivery);
        return "gametable";
    }

    @RequestMapping("/refresh")
    public String refresh(Model model) {
        List<Card> delivery = new ArrayList<>();
        service.init();
        List<Card> deck = service.getDeck();
        service.newGame();
        int counterPlayer = service.counterPlayer;
        int counterPC = service.counterPC;
        String score = "" + counterPlayer + ":" + counterPC;

        model.addAttribute("score",score);
        model.addAttribute("deck",deck);
        model.addAttribute("delivery", delivery);
        return "gametable";
    }

    @RequestMapping("/deck")
    public String showDeck(Model model){
        List<Card> deck = service.getDeck();
        model.addAttribute("deck",deck);
        return "deck";
    }
    @RequestMapping("/pick")
    public String pick(Model model){
        round = RoundService.initRound();
        List<Card> delivery = service.getCardList();
        int sum = delivery.stream().mapToInt(card-> card.getValue()).sum();

        if (sum >= 21) {
            return "redirect:/web/cards/stop";
        }
        int getDeckSize = service.getDeck().size();
        int roundCounter = service.round;
        round.setDelivery(delivery);

        model.addAttribute("round",round);
        model.addAttribute("sizeDeck");
        model.addAttribute("sum", sum);
        model.addAttribute("delivery",delivery);
        return "deck";
    }
    @RequestMapping("/stop")
    public  String stop(Model model){
        List<Card> delivery = service.getDelivery();
        int sum = delivery.stream().mapToInt(Card::getValue).sum();
        List<Card> forPC = service.getDeliveryForPC();
        int sum2 = forPC.stream().mapToInt(Card::getValue).sum();
         String message = service.getWinner(sum,sum2);
         int getDeckSize = service.getDeckSize();
         int counterPlayer = service.counterPlayer;
         int counterPC = service.counterPC;
         String score = "" + counterPlayer + ":" + counterPC;
         int roundCounter = service.roundCounter;
        System.out.println(delivery);

        /*round.setDeliveryPC(forPC);*/
        round.setFinish(LocalDateTime.now());
        if (message.equals("You are Winnner")) round.setWin(true);
        if (message.equals("You are losser")) round.setWin(false);
        round.setScore(score);
        round.setDelivery(delivery);
        round.setDeliveryPC(forPC);
        roundService.create(round);

        model.addAttribute("round",roundCounter);
        model.addAttribute("score",score);
         model.addAttribute("sizeDeck",getDeckSize);
        model.addAttribute("sum", sum);
        model.addAttribute("sum2", sum2);
        model.addAttribute("delivery",delivery);
        model.addAttribute("pcdelivery", forPC);
        model.addAttribute("message",message);

        return "deckpc";
    }

    public String showSixPike(Model model) {
        Card card = service.showSixPike();
        model.addAttribute("card", card);
        return "gametable";
    }

}
