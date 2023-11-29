package com.allen.login.api.service;

import com.allen.login.dto.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


public interface LoginService {
    String login(UserDto userDto) throws Exception;
}
