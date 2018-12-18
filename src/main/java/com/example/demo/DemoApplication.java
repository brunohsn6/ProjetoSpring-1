package com.example.demo;

import com.example.demo.model.Tweet;
import com.example.demo.model.User;
import com.example.demo.service.TweetService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Autowired
    TweetService tweetService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User u = new User();
        u.setNome("mariana");
        u.setEmail("quirino@gmail.com");
        u.setLogin("mari");
        u.setSenha("123");
        User u1 = new User();
        u1.setNome("teste");
        u1.setEmail("qwe@gmail.com");
        u1.setLogin("mari2");
        u1.setSenha("123");



//        userService.salvar(u);
        System.out.println(userService.salvar(u).getBody());
        List<User> userList = new ArrayList<>();
        userList.add(u);
        u1.setSeguindo(userList);
        System.out.println(userService.salvar(u1).getBody());

        Tweet tweet = new Tweet();
        tweet.setPost("Hello Word");
        tweet.setUser(u);
        tweetService.salvar(tweet);

        List<User> users = userService.listar();
        System.out.println("Nomes:");
        for (User user: users) {
            System.out.println(user.getLogin());
        }

        System.out.println(tweetService.feedUser(u).getPost());
    }
}

