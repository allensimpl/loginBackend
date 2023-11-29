package com.allen.login.security.utils;

import com.allen.login.dto.LoginDto;
import com.allen.login.dto.UserDto;
import com.allen.login.entity.User;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {
    @Autowired
    Gson gson;
    public String tokenGenerator(User user){
        LoginDto loginDto = LoginDto.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .build();

        Claims claims = Jwts.claims().setSubject(gson.toJson(loginDto));
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("https://www.wikipedia.org/")
                .signWith(SignatureAlgorithm.HS256,"v1r2a3m@l#e_o8")
                .compact();
    }
}