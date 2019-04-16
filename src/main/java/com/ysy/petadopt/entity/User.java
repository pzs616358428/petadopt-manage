package com.ysy.petadopt.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "p_user")
public class User {

    @Id
    private Integer userId;
    private String username;
    private String password;

}
