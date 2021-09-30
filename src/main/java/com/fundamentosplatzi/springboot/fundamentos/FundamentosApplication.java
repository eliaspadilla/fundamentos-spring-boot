package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanEP;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependencyEP;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependencyEP;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log logger = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependencyEP componentDependencyEP;
	private MyBeanEP myBean;
	private MyBeanWithDependencyEP myBeanWithDependencyEP;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	@Autowired
	public FundamentosApplication(@Qualifier("componentImplement2EP") ComponentDependencyEP componentDependencyEP,
									MyBeanEP myBean,
								  MyBeanWithDependencyEP myBeanWithDependencyEP,
								  MyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo,
								  UserRepository userRepository){
		this.componentDependencyEP = componentDependencyEP;
		this.myBean = myBean;
		this.myBeanWithDependencyEP = myBeanWithDependencyEP;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//ejemplosAnteriores();
		saveUsersInDatabase();
		getInfoJPQLFromUser();
	}

	private void saveUsersInDatabase(){
		User user1 = new User("Pepito Perez","pepito.perez@gmail.com",
				LocalDate.of(2021,03,20));
		User user2 = new User("Juan Carlos","juan.carlos@gmail.com",
				LocalDate.of(2021,01,05));
		User user3 = new User("John Doe","john.doe@gmail.com",
				LocalDate.of(2021,05,14));

		List<User> list = Arrays.asList(user1,user2,user3);

		list.forEach(userRepository::save);
	}

	private void ejemplosAnteriores(){
		componentDependencyEP.procesarDato();
		myBean.procesarNuevoDato();
		myBeanWithDependencyEP.printWithDependency();
		logger.info(myBeanWithProperties.funcionTest());
		logger.info(userPojo.getEmail() + "-" + userPojo.getPassword());
		logger.error("error manual");
	}

	private void getInfoJPQLFromUser(){
		logger.info("Consulta objeto = "+
				userRepository.findByUserEmail("juan.carlos@gmail.com")
						.orElseThrow(()-> new RuntimeException("No se encontro el usuario")));

		userRepository.findAndSort("J", Sort.by("id").ascending())
				.forEach(user -> logger.info("metodo sort "+user));
	}
}
