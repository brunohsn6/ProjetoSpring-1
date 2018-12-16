package com.example.demo.service;

import com.example.demo.exeception.UserException;
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
                throw new UserException("Nome usuario enviado invalido");
            }else if(!user.getEmail().contains("@")){
                throw new UserException("Email invalido");
            }else if(repository.findByLogin(user.getLogin()) != null){
                throw new UserException("Login já existe");
            }
//            return ResponseEntity.ok(repository.save(user));
            repository.save(user);
            return ResponseEntity.ok("Usuario inserido com sucesso");
        } catch (UserException e) {
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
