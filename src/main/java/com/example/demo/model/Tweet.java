package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Criado por Mariana
 * Data: 18/12/2018
 **/
@Entity
@Getter
@Setter
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String post;

    @ManyToOne
    private User user;
}
