package com.example.sserverapitest.controller;

import com.example.sserverapitest.model.User;
import com.example.sserverapitest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUserList();
    }

    @GetMapping("/user/{id}")
    public User getUsers(@PathVariable("id") int id){
        return userService.getUserByID(id);
    }

    @PostMapping("/add-user")
    public ResponseEntity<HttpStatus> create(@RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
