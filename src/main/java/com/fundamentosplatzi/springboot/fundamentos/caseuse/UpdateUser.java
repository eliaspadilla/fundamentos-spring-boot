package com.fundamentosplatzi.springboot.fundamentos.caseuse;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;

public interface UpdateUser {
    User update(User newUser, Long id);
}
