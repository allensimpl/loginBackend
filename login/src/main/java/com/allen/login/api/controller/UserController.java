package com.allen.login.api.controller;

import com.allen.login.api.service.UserService;
import com.allen.login.dto.UserDto;
import com.allen.login.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return service.getAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public User addUser(@RequestBody UserDto user){
        return service.addUser(user);
    }
}
