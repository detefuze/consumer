package com.ru.klimash.consumer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "food_order")
@NoArgsConstructor
@AllArgsConstructor
public class FoodOrder {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "item")
    private String item;
    @Column(name = "amount")
    private double amount;
}
