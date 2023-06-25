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
}
