package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyOperationImplementEP implements MyOperationEP{
    @Override
    public int suma(int num1, int num2) {
        return num1 + num2;
    }
}
