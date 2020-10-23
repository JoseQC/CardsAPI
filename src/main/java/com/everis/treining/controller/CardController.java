package com.everis.treining.controller;

import com.everis.treining.entity.Card;
import com.everis.treining.entity.CardResponse;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "core/")
public class CardController {

  @Value("${numbercard}")
  String numberCard;

  /**
   * Comment Method.
   * 
   * 
   */
  @GetMapping("/cards")
  public Single<CardResponse> getPerson(@RequestParam("documentNumber") String docNum) {

    if (docNum.isEmpty()) {
      return Single.just(new CardResponse());
    }

    CardResponse cardResponse = new CardResponse();
    List<Card> listCard = new ArrayList<>();

    Arrays.asList(1, 2, 3, 4, 5, 6).stream().forEach(x -> {
      String numcard = numberCard + x.toString();
      boolean activ = true;

      if (x > 3) {
        activ = false;
      }
      Card card = new Card(numcard, activ);
      listCard.add(card);
    });
    cardResponse.setListCards(listCard);
    return Single.just(cardResponse);
  }

}
