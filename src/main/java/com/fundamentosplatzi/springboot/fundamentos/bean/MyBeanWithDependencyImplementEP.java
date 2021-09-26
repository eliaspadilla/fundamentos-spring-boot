package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBeanWithDependencyImplementEP implements MyBeanWithDependencyEP{
    private final Log logger = LogFactory.getLog(MyBeanWithDependencyImplementEP.class);
    private MyOperationEP myOperationEP;

    @Autowired
    public MyBeanWithDependencyImplementEP(MyOperationEP myOperationEP) {
        this.myOperationEP = myOperationEP;
    }

    @Override
    public void printWithDependency() {
        int resultado = myOperationEP.suma(5,4);
        logger.info("Procesa desde MyBeanWithDependencyImplementEP, suma = "+resultado);
    }
}
