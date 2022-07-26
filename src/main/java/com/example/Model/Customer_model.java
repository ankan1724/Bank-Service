package com.example.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="BANK_CUSTOMER_DETAILS")
public class Customer_model {
  
    @Id
    private long acc_number;
    private String acc_holder;
    private String address;
    private long pincode;
    @Enumerated(EnumType.STRING)
    private KycDetails kycDetails;
    @Enumerated(EnumType.STRING)
    private Type acc_type;
}