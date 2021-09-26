package com.fundamentosplatzi.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplementEP implements ComponentDependencyEP{
    @Override
    public void procesarDato() {
        System.out.println("Procesa dato desde mi componente");
    }
}
