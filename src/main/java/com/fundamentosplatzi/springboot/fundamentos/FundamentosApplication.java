package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanEP;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependencyEP;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependencyEP;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log logger = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependencyEP componentDependencyEP;
	private MyBeanEP myBean;
	private MyBeanWithDependencyEP myBeanWithDependencyEP;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	@Autowired
	public FundamentosApplication(@Qualifier("componentImplement2EP") ComponentDependencyEP componentDependencyEP,
									MyBeanEP myBean,
								  MyBeanWithDependencyEP myBeanWithDependencyEP,
								  MyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo){
		this.componentDependencyEP = componentDependencyEP;
		this.myBean = myBean;
		this.myBeanWithDependencyEP = myBeanWithDependencyEP;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		componentDependencyEP.procesarDato();
		myBean.procesarNuevoDato();
		myBeanWithDependencyEP.printWithDependency();
		logger.info(myBeanWithProperties.funcionTest());
		logger.info(userPojo.getEmail() + "-" + userPojo.getPassword());
		logger.error("error manual");
	}
}
