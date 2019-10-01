package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Criado por Mariana
 * Data: 18/12/2018
 **/
/*
A nice tip to keep your model cleaner is to use the @Data annotation instead of @Getter and Setter!
Lombok provides to you the annotation @Data that works perfectly for whose wants do keep the code clean and it replaces
the need of use @Getter, @Setter, @EqualsAndHashCode, @RequiredArgsConstructor and @ToString at same! 
*/
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

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Tweet> comentario;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> curtida;
}
