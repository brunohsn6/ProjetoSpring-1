package com.example.demo.service;

import com.example.demo.exeception.NomeInvalidoException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Criado por Mariana
 * Data: 15/12/2018
 **/

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> listar() {
        return repository.findAll();
    }

    public ResponseEntity salvar(User user) {
        try {
            if (user.getNome() == null || user.getNome().isEmpty()) {
                throw new NomeInvalidoException("Nome usuario enviado invalido");
            }
            return ResponseEntity.ok(repository.save(user));
        } catch (NomeInvalidoException e) {
            e.printStackTrace();
            return ResponseEntity.ok(e.getMessage());
        }
    }

    public User buscarNome(String nome) {
        User u = new User();
        u.setNome(nome);
        return repository.findByNome(nome);
    }
}
