package com.example.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CARDS_DB")
public class Cards {
    @Id 
    @Size(min = 16, max = 16)
    private Long cardNumber;
@Enumerated(EnumType.STRING)
private CardType cardType;
private double limits;
private double used;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "acc_number", nullable = false)
@JsonIgnore
private Customer_model customer_model;
}