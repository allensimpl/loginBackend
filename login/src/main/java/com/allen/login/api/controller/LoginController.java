package com.allen.login.api.controller;

import com.allen.login.api.service.LoginService;
import com.allen.login.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(method = RequestMethod.POST)
    public String login(@RequestBody UserDto userDto) throws Exception {
        return loginService.login(userDto);
    }
}
