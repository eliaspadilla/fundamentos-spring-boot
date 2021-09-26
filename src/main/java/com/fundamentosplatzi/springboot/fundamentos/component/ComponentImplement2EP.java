package com.fundamentosplatzi.springboot.fundamentos.component;

import com.fundamentosplatzi.springboot.fundamentos.FundamentosApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class ComponentImplement2EP implements ComponentDependencyEP{
    private final Log logger = LogFactory.getLog(ComponentImplement2EP.class);

    @Override
    public void procesarDato() {
        logger.info("procesa dato desde el 2 componente");
    }
}
