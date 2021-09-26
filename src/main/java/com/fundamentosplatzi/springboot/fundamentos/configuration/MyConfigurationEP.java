package com.fundamentosplatzi.springboot.fundamentos.configuration;

import com.fundamentosplatzi.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationEP {

    @Bean
    public MyBeanEP beanOperationEP(){
        return new MyBeanImplement2EP();
    }

    @Bean
    public MyOperationEP beanOperationSumaEP(){
        return new MyOperationImplementEP();
    }

    @Bean
    public MyBeanWithDependencyEP beanOperationImpSumaEP(MyOperationEP myOperationEP){
        return new MyBeanWithDependencyImplementEP(myOperationEP);
    }
}
