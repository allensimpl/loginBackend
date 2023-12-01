package com.allen.login.api.service.impl;

import com.allen.login.api.service.ProfileService;
import com.allen.login.dto.SubjectDto;
import com.allen.login.entity.User;
import com.allen.login.repository.UserRepository;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    Gson gson;
    @Override
    public User getUser(String token){
        String authToken = token.split(" ")[1];
        Claims claims = Jwts.parser().setSigningKey("v1r2a3m@l#e_o8").parseClaimsJws(authToken).getBody();
        String sub = claims.getSubject();
        SubjectDto subjectDto = gson.fromJson(sub,SubjectDto.class);
//        return (User) claims;
        User user =  userRepository.findById(subjectDto.getId()).orElse(null);
        return user;
    }
}
