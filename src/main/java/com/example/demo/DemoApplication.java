package com.example.demo;

import com.example.demo.model.Tweet;
import com.example.demo.model.User;
import com.example.demo.service.TweetService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
//        User u1 = new User();
//        u1.setNome("teste");
//        u1.setEmail("qu1irino@gmail.com");
//        u1.setLogin("mari2");



//        userService.salvar(u);
        System.out.println(userService.salvar(u).getBody());
//        System.out.println(userService.salvar(u1).getBody());
        //
//        User result = (User) userService.salvar(u1).getBody();
//        System.out.println(result.getNome());

        Tweet tweet = new Tweet();
        tweet.setPost("Hello Word");
        tweetService.salvar(tweet);

        List<User> users = userService.listar();
        System.out.println("Nomes:");
        for (User user: users) {
            System.out.println(user.getLogin());
        }

    }
}

