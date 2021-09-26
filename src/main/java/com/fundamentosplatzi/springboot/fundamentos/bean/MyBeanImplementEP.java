package com.fundamentosplatzi.springboot.fundamentos.bean;

import com.fundamentosplatzi.springboot.fundamentos.FundamentosApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanImplementEP implements MyBeanEP{
    private final Log logger = LogFactory.getLog(MyBeanImplementEP.class);

    @Override
    public void procesarNuevoDato() {
        logger.info("Procesa dato desde mybean");
    }
}
