package com.allen.login.api.service.impl;

import com.allen.login.api.service.LoginService;
import com.allen.login.dto.UserDto;
import com.allen.login.entity.User;
import com.allen.login.repository.UserRepository;
import com.allen.login.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service(value = "LoginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserRepository repository;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public String login(UserDto userDto) throws Exception {
        User user = repository.findByName(userDto.getName());
        if(user==null){
            throw new Exception("Name not found!");
        }
        if(encoder.matches(userDto.getPassword(),user.getPassword())){
            return jwtTokenUtil.tokenGenerator(user);
        }
        return "Login Failed";
    }
}
