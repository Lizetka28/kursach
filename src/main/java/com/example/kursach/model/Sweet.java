package com.example.kursach.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="sweet")
public class Sweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="type")
    private String type;
    @Column(name="price")
    private double price;
    @Column(name="weight")
    private int weight;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)//связь с таблицей фабрик по принципу " на одной фабрике могут производиться разные конфеты"
    @JoinColumn
    private Factory factory;
}
