package com.clemen.proyecto.controller;

import com.clemen.proyecto.dao.UserDAO;
import com.clemen.proyecto.entities.User;
import com.clemen.proyecto.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    private UserRepository userRepository;
    private UserDAO userDao;

    public UserController(UserRepository userRepository, UserDAO userDao) {

        this.userRepository=userRepository;
        this.userDao=userDao;
    }


    // Mostrar Jpa Repository
    @GetMapping("/api/users")
    private List<User> findAll(){

        return this.userRepository.findAll();
    }

    // Mostrar Jpa Repository
    @GetMapping("/api/usersCriteria")
    private List<User> findAllCriteria(){

       return this.userDao.findAllActive();
    }

    // Crear
    @PostMapping("/api/users")
    private User create(@RequestBody User user){

        return this.userRepository.save(user);
    }
}
