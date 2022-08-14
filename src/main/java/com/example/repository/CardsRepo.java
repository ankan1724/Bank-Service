package com.example.repository;

import com.example.Model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardsRepo extends JpaRepository<Cards, Long> {
}