package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanEP;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependencyEP;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependencyEP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependencyEP componentDependencyEP;
	private MyBeanEP myBean;
	private MyBeanWithDependencyEP myBeanWithDependencyEP;

	@Autowired
	public FundamentosApplication(@Qualifier("componentImplement2EP") ComponentDependencyEP componentDependencyEP,
									MyBeanEP myBean,
								  MyBeanWithDependencyEP myBeanWithDependencyEP){
		this.componentDependencyEP = componentDependencyEP;
		this.myBean = myBean;
		this.myBeanWithDependencyEP = myBeanWithDependencyEP;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		componentDependencyEP.procesarDato();
		myBean.procesarNuevoDato();
		myBeanWithDependencyEP.printWithDependency();
	}
}
