package com.fundamentosplatzi.springboot.fundamentos.caseuse;

import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

public class UpdateUserImplement implements UpdateUser{
    private UserService userService;

    public UpdateUserImplement(UserService userService) {
        this.userService = userService;
    }
}
