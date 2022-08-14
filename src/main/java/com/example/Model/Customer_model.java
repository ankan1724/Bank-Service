package com.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @NonNull
    private String acc_holder;
    @NonNull
    private String address;
    @NonNull
    private long pincode;
    @Enumerated(EnumType.STRING)
    @NonNull
    private Type acc_type;
    @OneToMany(mappedBy = "customer_model" ,cascade = CascadeType.ALL,  fetch =FetchType.EAGER)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Cards> cards    =    new HashSet<>();
   
}