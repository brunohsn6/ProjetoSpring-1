package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private List<Tweet> comentario;


}
