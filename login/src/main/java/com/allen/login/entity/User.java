package com.allen.login.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="user_tbl")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;
}
