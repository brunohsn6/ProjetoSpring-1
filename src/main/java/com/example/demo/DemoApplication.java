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
        User u1 = new User();
        u1.setNome("teste");
        u1.setEmail("qu1irino@gmail.com");
        u1.setLogin("mari2");

        System.out.println(service.salvar(u).getBody());
        System.out.println(service.salvar(u1).getBody());
        //
//        User result = (User) service.salvar(u1).getBody();
//        System.out.println(result.getNome());

        List<User> users = service.listar();
        System.out.println("Nomes:");
        for (User user: users) {
            System.out.println(user.getLogin());
        }

    }
}

