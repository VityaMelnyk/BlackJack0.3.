package edu.blackjack.service.round;

import edu.blackjack.model.Round;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RoundService {

    public static Round initRound() {
        Round round = new Round();
        round.setUserName("Viktor");
        round.setStart(LocalDateTime.now());

        return round;
    }

    public Round create(Round round){

        System.out.println(round);
        return null;
    }

}
