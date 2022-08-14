package com.example.controller;

import com.example.Model.Customer_model;
import com.example.Model.Type;
import com.example.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @PostMapping("/add")
    @ApiOperation("to add a new customer")
    @PreAuthorize("hasPermission('ADMIN'')")
    public String newCustomer(@Valid @RequestParam(value = "acc_holder",required = true) String acc_holder,
                              @RequestParam(value = "address",required = true)String address,
                              @RequestParam(value = "pincode",required = true)long pincode,
                              @RequestParam(value = "acc_type",required = true)Type acc_type
                              ) { 
        this.customerService.newCustomer(acc_holder,address,pincode,acc_type);
        return "Customer added Successfully";
    }

    @GetMapping("/getById")
    @ApiOperation("to get customer details by Acc_Number")
    public Optional<Customer_model> getCustomerByAcc_Number(@Valid@RequestParam(name="acc_number", required = true)Long acc_number){
        return this.customerService.getcustomerbyid(acc_number);
}
    @GetMapping("/all")
    @ApiOperation("to get list of Customers")
    @PreAuthorize("hasPermission('ADMIN'')")
public List<Customer_model>  getAllCustomer(){
    return   this.customerService.getAllCustomer();
}


    /*@DeleteMapping("/deleteByid")
    @ApiOperation("to delete ")
    public String deleteCustomer(@RequestParam(name="acc_number", required = true)Long acc_number){
        this.customerService.deleteCustomer(acc_number);
        return "customer details removed";
    }
    
    @PutMapping("/updateById")
    @ApiOperation("to update kyc of existing customer")
    public Customer_model updateKyc(@RequestParam(value = "acc_number", required = true) Long acc_number,
                                    @RequestBody Customer_model customer_model){
        return this.customerService.updateKyc(acc_number,customer_model);
    }*/
}