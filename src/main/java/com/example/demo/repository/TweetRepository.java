package com.example.demo.repository;

import com.example.demo.model.Tweet;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Criado por Mariana
 * Data: 18/12/2018
 **/
public interface TweetRepository extends JpaRepository<Tweet, Long> {

//    Tweet findByUser(User user);
}
