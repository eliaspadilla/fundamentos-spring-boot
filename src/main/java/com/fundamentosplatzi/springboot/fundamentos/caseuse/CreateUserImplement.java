package com.fundamentosplatzi.springboot.fundamentos.caseuse;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

public class CreateUserImplement implements CreateUser {
    private UserService userService;

    public CreateUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User save(User newUser) {
        return userService.save(newUser);
    }
}
