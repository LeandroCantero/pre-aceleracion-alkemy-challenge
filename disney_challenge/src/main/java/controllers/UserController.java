package controllers;

import models.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import repositories.UserRepository;
import services.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ArrayList<UserEntity> getUser(){
        return userService.getUsers();
    }

    @PostMapping(path = "/add")
    public UserEntity saveUser(@RequestBody UserEntity user){
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
