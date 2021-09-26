package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class MyBeanWithDependencyImplementEP implements MyBeanWithDependencyEP{
    private MyOperationEP myOperationEP;

    @Autowired
    public MyBeanWithDependencyImplementEP(MyOperationEP myOperationEP) {
        this.myOperationEP = myOperationEP;
    }

    @Override
    public void printWithDependency() {
        int resultado = myOperationEP.suma(5,4);
        System.out.println("Procesa desde MyBeanWithDependencyImplementEP, suma = "+resultado);
    }
}
