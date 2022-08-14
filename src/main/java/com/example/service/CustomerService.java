package com.example.service;

import com.example.ExceptionHandlers.CustomerException;
import com.example.Model.Cards;
import com.example.Model.Customer_model;
import com.example.Model.Type;
import com.example.repository.CardsRepo;
import com.example.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CardsRepo cardsRepo;
 

    public String newCustomer(String acc_holder, String address, long pincode, Type acc_type) {
        Customer_model customer_model = new Customer_model();
        customer_model.setAcc_holder(acc_holder.toUpperCase(Locale.ROOT));
        customer_model.setPincode(pincode);
        customer_model.setAddress(address.toUpperCase(Locale.ROOT));
        long account_number = (long) (Math.random() * 100000000000000L);
        long number = 5200000000000000L + account_number;
        customer_model.setAcc_number(number);
        customer_model.setAcc_type(acc_type);
        this.customerRepo.save(customer_model);
        return "new account created";
    }

    public Optional<Customer_model> getcustomerbyid(Long  acc_number)throws RuntimeException{
      Optional<Customer_model> customer_model=this.customerRepo.findById(acc_number)  ;
      if(!customer_model.isPresent()){
          throw   new CustomerException("Customer","Account number", acc_number);
      }else {
          return  customer_model;
      }
    }
   
    public List<Customer_model> getAllCustomer() {
        return this.customerRepo.findAll();
    }
}