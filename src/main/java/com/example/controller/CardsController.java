package com.example.controller;

import com.example.Model.CardType;
import com.example.Model.Cards;
import com.example.service.CardsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/cards")
public class CardsController {
    
    @Autowired private CardsService cardsService;

@PostMapping("/add")
@ApiOperation("to add cards for a particular account")
    public Cards addCards(Long acc_number, Long cardNumber, CardType cardType, double limits, double used) {
        return this.cardsService.addCards(acc_number, cardNumber, cardType, limits, used);
    }
    @GetMapping("/showByAccountNumber")
    @ApiOperation("to show  cards for a particular account")
    public Set<Cards> showCardsbyaccNumber(@RequestParam Long acc_number){
    return this.cardsService.showCardsbyaccNumber(acc_number);
    }
}