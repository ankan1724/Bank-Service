package com.example.service;

import com.example.Model.Customer_model;
import com.example.Model.KycDetails;
import com.example.Model.Type;
import com.example.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
   /* @Autowired
    private Customer_model customer_model;*/

    public String newCustomer(String acc_holder, String address, long pincode, Type acc_type, KycDetails kycDetails) {
        Customer_model customer_model = new Customer_model();
        customer_model.setAcc_holder(acc_holder.toUpperCase(Locale.ROOT));
        customer_model.setPincode(pincode);
        customer_model.setAddress(address.toUpperCase(Locale.ROOT));
        long account_number = (long) (Math.random() * 100000000000000L);
        long number = 5200000000000000L + account_number;
        customer_model.setAcc_number(number);
        customer_model.setAcc_type(acc_type);
        customer_model.setKycDetails(kycDetails);
        this.customerRepo.save(customer_model);
        return "new account created";
    }

    public Optional<Customer_model> getcustomerbyid(Long  acc_number){
       return  this.customerRepo.findById(acc_number);
    }
   
}