package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.constraints.Max;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    UserService service;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        User u = new User();
//        u.setNome("mariana");
//        u.setIdade(21);
//
//        service.salvar(u);


//         List<User> users = service.salvar(u);



//        service.listar();

    }
}

