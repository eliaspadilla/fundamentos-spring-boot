package com.fundamentosplatzi.springboot.fundamentos.configuration;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanEP;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanImplementEP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationEP {

    @Bean
    public MyBeanEP beanOperationEP(){
        return new MyBeanImplementEP();
    }
}
