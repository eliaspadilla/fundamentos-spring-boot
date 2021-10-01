package com.fundamentosplatzi.springboot.fundamentos.configuration;

import com.fundamentosplatzi.springboot.fundamentos.caseuse.*;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getuser(UserService userService){
        return new GetUserImplement(userService);
    }

    @Bean
    CreateUser createuser(UserService userService){
        return new CreateUserImplement(userService);
    }

    @Bean
    UpdateUser updateuser(UserService userService){
        return new UpdateUserImplement(userService);
    }

    @Bean
    DeleteUser deleteuser(UserService userService){
        return new DeleteUserImplement(userService);
    }
}
