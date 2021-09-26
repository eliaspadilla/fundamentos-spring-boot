package com.fundamentosplatzi.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement2EP implements ComponentDependencyEP{
    @Override
    public void procesarDato() {
        System.out.println("procesa dato desde el 2 componente");
    }
}
