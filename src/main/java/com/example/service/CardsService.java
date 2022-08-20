package com.example.service;

import com.example.ExceptionHandlers.CustomerException;
import com.example.Model.CardType;
import com.example.Model.Cards;
import com.example.Model.Customer_model;
import com.example.repository.CardsRepo;
import com.example.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CardsService {
    @Autowired
    private CardsRepo cardsRepo;
    @Autowired
    private CustomerRepo customerRepo;

    public Cards addCards(Long acc_number, Long cardNumber, CardType cardType, double limits, double used) {
        
            Cards cards = new Cards();
            cards.setCardNumber(cardNumber);
            cards.setCardType(cardType);
            Optional<Customer_model> optional_customer_model = customerRepo.findById(acc_number);
            Customer_model customer_model = optional_customer_model.get();
            cards.setCustomer_model(customer_model);
            if (cards.getCardType() == CardType.CREDIT) {
                cards.setLimits(limits);
                cards.setUsed(used);
            } else {
                cards.setLimits(0.0);
                cards.setUsed(0.0);
            }
            return this.cardsRepo.save(cards);
       
        }
    

    public Set<Cards> showCardsbyaccNumber(Long acc_number) throws RuntimeException {
        Optional<Customer_model> optional_customer_model = customerRepo.findById(acc_number);
        if(! optional_customer_model.isPresent()) {
            throw new CustomerException("Customer", "Account Number", acc_number);
        } else {
            List<Customer_model> customer_model = Collections.singletonList(optional_customer_model.get());
            Customer_model customer = customer_model.get(0);
            Set<Cards> cardsList = customer.getCards();
            if(cardsList.size()<=0){
                System.out.println("no cards has been issued for this customer");
            }
            return cardsList;
        }
    }
}