package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.Max;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    UserService service;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User u = new User();
        u.setNome("mariana");
        u.setEmail("quirino@gmail.com");
        u.setLogin("mari");

        System.out.println(service.salvar(u));





        List<User> users = service.listar();
        System.out.println("Nomes");
        for (User user: users) {
            System.out.println(user.getNome());
        }

    }
}

