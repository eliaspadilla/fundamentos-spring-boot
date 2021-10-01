package com.fundamentosplatzi.springboot.fundamentos.caseuse;

import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

public class DeleteUserImplement implements DeleteUser{
    private UserService userService;

    public DeleteUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void remove(Long id) {
        userService.delete(id);
    }
}
