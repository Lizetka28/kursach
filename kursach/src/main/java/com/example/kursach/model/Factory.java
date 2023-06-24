package com.example.kursach.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="factory")
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="workers")
    private int workers;
    @Column(name="owner")
    private String owner;

}
