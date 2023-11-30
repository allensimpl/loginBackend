package com.allen.login.api.service;

import com.allen.login.dto.UserDto;
import com.allen.login.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAll();
    public User addUser(UserDto user);
}
