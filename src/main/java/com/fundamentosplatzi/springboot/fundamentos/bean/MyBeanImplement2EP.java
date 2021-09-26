package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyBeanImplement2EP implements MyBeanEP{
    @Override
    public void procesarNuevoDato() {
        System.out.println("Procesa dato desde mybean 2");
    }
}
