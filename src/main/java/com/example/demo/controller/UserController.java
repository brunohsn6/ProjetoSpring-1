package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Criado por Mariana
 * Data: 15/12/2018
 **/

@RestController
@RequestMapping(path = "/usuario")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(path = "/inserir")
    public ResponseEntity inserir(@RequestBody User user){
        return service.salvar(user);
    }

    @GetMapping(path = "/listar")
    public List<User> listar(){
        return service.listar();
    }

    @GetMapping (path = "/buscarEmail")
    public User buscarNome(@PathVariable String nome){
        return service.buscarNome(nome);
    }


}
