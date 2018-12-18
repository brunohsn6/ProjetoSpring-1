package com.example.demo.controller;

import com.example.demo.model.Tweet;
import com.example.demo.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Criado por Mariana
 * Data: 18/12/2018
 **/

@RestController
@RequestMapping(path = "/tweet")
public class TweetController {

    @Autowired
    private TweetService service;

    @PostMapping(path = "/inserir")
    public ResponseEntity inserir(@RequestBody Tweet tweet){
        return service.salvar(tweet);
    }

    @GetMapping(path = "/listar")
    public List<Tweet> listar(){
        return service.listar();
    }
}
