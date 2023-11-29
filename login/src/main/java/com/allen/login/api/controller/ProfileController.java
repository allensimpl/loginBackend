package com.allen.login.api.controller;

import com.allen.login.api.service.ProfileService;
import com.allen.login.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;
    @RequestMapping(method = RequestMethod.POST)
    public User getUser(@RequestHeader(name = "Authorization") String token){
        return profileService.getUser(token);
    }
}
