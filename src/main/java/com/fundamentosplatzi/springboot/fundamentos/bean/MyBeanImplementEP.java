package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyBeanImplementEP implements MyBeanEP{
    @Override
    public void procesarNuevoDato() {
        System.out.println("Procesa dato desde mybean");
    }
}
