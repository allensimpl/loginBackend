package com.allen.login.api.service;

import com.allen.login.api.service.impl.ProfileServiceImpl;
import com.allen.login.entity.User;
import com.allen.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface ProfileService {
    User getUser(String token);
}
