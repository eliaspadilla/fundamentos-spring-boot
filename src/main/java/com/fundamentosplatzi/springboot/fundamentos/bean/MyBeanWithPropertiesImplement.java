package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties{
    private String datoN;
    private String datoA;

    public MyBeanWithPropertiesImplement(String datoN, String datoA) {
        this.datoN = datoN;
        this.datoA = datoA;
    }

    @Override
    public String funcionTest() {
        return "Dato Nombre ("+datoN+") Apellido ("+datoA+")";
    }
}
