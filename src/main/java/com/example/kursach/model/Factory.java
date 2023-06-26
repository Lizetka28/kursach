package com.example.kursach.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "factory")//связь с таблицей конфет по принципу " на одной фабрике могут производиться разные конфеты"
    private List<Sweet> sweets=new ArrayList<>();
}
