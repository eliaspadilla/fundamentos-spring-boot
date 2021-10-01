package com.fundamentosplatzi.springboot.fundamentos.caseuse;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

public class UpdateUserImplement implements UpdateUser{
    private UserService userService;

    public UpdateUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User update(User newUser, Long id) {
        return userService.update(newUser,id);
    }
}
