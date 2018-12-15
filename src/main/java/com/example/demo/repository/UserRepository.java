package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Criado por Mariana
 * Data: 15/12/2018
 **/
public interface UserRepository extends JpaRepository<User, Long> {

    User findByNome(String nome);


}
