package com.allen.login.api.service.impl;

import com.allen.login.api.service.UserService;
import com.allen.login.dto.UserDto;
import com.allen.login.entity.User;
import com.allen.login.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;

@Service
//@RequiredArgsConstructor
//@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Override
    public List<User> getAll(){
        return repository.findAll();
    }

    @Override
    public User addUser(UserDto userDto){

        User user = User.builder()
                .name(userDto.getName())
                .password(new BCryptPasswordEncoder(12).encode(userDto.getPassword()))
                .build();
        return repository.save(user);
    }
}
